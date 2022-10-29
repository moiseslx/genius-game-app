package com.application.genius.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputUserName, inputName, inputEmail, inputPassword;

    private Button btnSignUp;
    private ImageButton btnReturn;
    private ProgressBar progressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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

    }

    private void startComponents() {
        inputName = findViewById(R.id.editTextName);
        inputEmail = findViewById(R.id.editTextEmailR);
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

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (email.isEmpty()) {
                inputEmail.setError("Adicione seu email...");
                inputEmail.requestFocus();
            } else {
                inputEmail.setError("Email inválido!");
                inputEmail.requestFocus();
            }
        }

        if (password.length() < 8) {
            inputPassword.setError("Crie uma senha de no mínimo 6 caracters!");
            inputPassword.requestFocus();
        }

        if (fullName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_SHORT).show();

        } else {
            progressBar.setVisibility(View.VISIBLE);
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        User user = new User(userName.trim(), fullName.trim(), email.trim());

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                        firebaseDatabase.getReference("Users").
                                child(Objects.requireNonNull(auth.getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                            finish();
                                        }
                                    }
                                });
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
        }
    }
}

