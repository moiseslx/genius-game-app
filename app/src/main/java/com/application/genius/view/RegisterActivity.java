package com.application.genius.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.application.genius.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputEmail;
    private EditText inputPassword;

    private Button btnSignUp;
    private ImageView btnReturn;

    String error;
    String[] alerts = {"Preencha todos os campos...", "Cadastro realizado com sucesso!", "Erro ao cadastrar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        startComponents();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
/*
                Intent intent = new Intent(getApplicationContext(), Test.class);
                startActivity(intent);
                finish();
*/
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void startComponents() {
        inputName = findViewById(R.id.editTextName);
        inputEmail = findViewById(R.id.editTextEmailR);
        inputPassword = findViewById(R.id.editTextPasswordR);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnReturn = findViewById(R.id.btnReturn);
    }

    private void register() {

    }
}

