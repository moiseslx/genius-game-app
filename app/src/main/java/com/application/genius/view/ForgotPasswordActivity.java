package com.application.genius.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.application.genius.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ImageView btnReturn = findViewById(R.id.btnReturnF);
        EditText inputEmail = findViewById(R.id.editTextEmailF);
        Button btnSend = findViewById(R.id.btnSend);

        btnReturn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });

        btnSend.setOnClickListener(view -> {
            String email = inputEmail.getText().toString();
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (email.isEmpty()) {
                    inputEmail.setError("Adicione seu email...");
                    inputEmail.requestFocus();
                } else {
                    inputEmail.setError("Email inválido!");
                    inputEmail.requestFocus();
                }
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email);

                Toast.makeText(getApplicationContext(), "Verifique seu email", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}