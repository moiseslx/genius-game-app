package com.application.genius.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.application.genius.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.application.genius.model.Firebase;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail;
    private EditText inputPassword;
    private TextView forgotPassword;
    private TextView signUp;
    private Button btnLogin;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startComponents();

        auth = Firebase.getFirebaseAuth();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    getLogin();

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);
                finish();
*/
            }
        });

    }

    private void startComponents() {
        inputEmail = findViewById(R.id.editTextEmailL);
        inputPassword = findViewById(R.id.editTextPasswordL);
        forgotPassword = findViewById(R.id.textViewForgotPassword);
        signUp = findViewById(R.id.textViewSignUp);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void getLogin() {
        if (inputEmail.getText().toString().isEmpty() || inputPassword.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Preencha todos os campos !", Toast.LENGTH_SHORT).show();
        } else {
            auth.signInWithEmailAndPassword(inputEmail.getText().toString(), inputPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        // ESTOU INSTANCIANDO UMA PARA UMA CLASSE TESTE
                        /*
                        Intent intent = new Intent(getApplicationContext(), Test.class);
                        startActivity(intent);
                        finish();*/

                        System.out.print("deu bom");
                    }
                }
            });
        }
    }
}