package com.application.genius.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.application.genius.R;
import com.application.genius.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputUserName, inputName, inputEmail, inputPassword;

    private Button btnSignUp;
    private ImageButton btnReturn;
    private ProgressBar progressBar;

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        auth = FirebaseAuth.getInstance();

        startComponents();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseApp.initializeApp(getApplicationContext());
        database = FirebaseDatabase.getInstance();

    }

    private void startComponents() {
        inputName = findViewById(R.id.editTextName);
        inputEmail = findViewById(R.id.editTextEmailF);
        inputPassword = findViewById(R.id.editTextPasswordR);
        inputUserName = findViewById(R.id.editTextUserName);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnReturn = findViewById(R.id.btnReturn);
        progressBar = findViewById(R.id.progressBar2);
    }

    private void register(View view) {
        String userName = inputUserName.getText().toString();
        String fullName = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        progressBar.setVisibility(View.VISIBLE);

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            progressBar.setVisibility(View.INVISIBLE);
            if (email.isEmpty()) {
                inputEmail.setError("Adicione seu email...");
                inputEmail.requestFocus();
            } else {
                inputEmail.setError("Email inválido!");
                inputEmail.requestFocus();
            }
        }

        if (password.length() < 8) {
            progressBar.setVisibility(View.INVISIBLE);
            inputPassword.setError("Crie uma senha de no mínimo 6 caracters!");
            inputPassword.requestFocus();
        }

        if (fullName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            progressBar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_SHORT).show();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            createLogin(userName, password, email, fullName);
        }
    }

    private void createLogin(String username, String password, String email, String fullName) {

        database.getReference().child("usernames").child(inputUserName.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                User user = new User(username.trim(), fullName.trim(), email.trim());
                                user.setScore(0);

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                                firebaseDatabase.getReference("users").
                                        child(Objects.requireNonNull(auth.getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                                    startActivity(new Intent(getApplicationContext(), SplashScreenActivity.class));
                                                    finish();
                                                }
                                            }
                                        });

                                firebaseDatabase.getReference("usernames").child(username.trim().toLowerCase()).setValue(Objects.requireNonNull(auth.getCurrentUser()).getUid());
                                database = null;
                            } else {
                                progressBar.setVisibility(View.INVISIBLE);
                                String err;
                                try {
                                    throw Objects.requireNonNull(task.getException());
                                } catch (FirebaseAuthUserCollisionException e) {
                                    err = "Está conta já foi cadastrada!";
                                } catch (Exception e) {
                                    err = "Erro ao cadastrar";
                                }
                                Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    if (database != null){
                        progressBar.setVisibility(View.INVISIBLE);
                        inputUserName.setError("Este nome está em uso!");
                        inputUserName.requestFocus();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("Acess usernames", "onCancelled");
            }
        });
    }


}


