package com.application.genius.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.application.genius.R;
import com.application.genius.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputEmail;
    private EditText inputPassword;

    private Button btnSignUp;
    private ImageView btnReturn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        startComponents();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();

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

        auth = FirebaseAuth.getInstance();

    }

    private void startComponents() {
        inputName = findViewById(R.id.editTextName);
        inputEmail = findViewById(R.id.editTextEmailR);
        inputPassword = findViewById(R.id.editTextPasswordR);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnReturn = findViewById(R.id.btnReturn);
    }

    private void register() {
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if(name.isEmpty()){
            inputName.setError("Diga seu nome!");
            inputName.requestFocus();
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (email.isEmpty()) {
                inputEmail.setError("Adicione seu email...");
                inputEmail.requestFocus();
            } else {
                inputEmail.setError("Email inválido!");
                inputEmail.requestFocus();
            }
        }

        if (password.length() < 6){
            inputPassword.setError("Crie uma senha de no mínimo 6 caracters!");
            inputPassword.requestFocus();
        }

        if(password.isEmpty()){
            inputPassword.setError("Adicione uma senha...");
            inputPassword.requestFocus();
        }

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_SHORT).show();

        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        User user = new User(name, email);

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                        firebaseDatabase.getReference("Users").
                                child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Erro ao cadastrar: " + task.getException(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            });
        }
    }
}

