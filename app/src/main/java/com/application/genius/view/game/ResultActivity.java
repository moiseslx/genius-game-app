package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.application.genius.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView result,message,equations;
    Button ok;
    String c, t;
    ArrayList<String> list;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.textViewResultMessage);
        message = findViewById(R.id.textViewMessage);
        equations = findViewById(R.id.textViewEquations);

        ok = findViewById(R.id.btnOk);

        Intent intent = getIntent();
        c = intent.getStringExtra("CORRECT");
        t = intent.getStringExtra("TOTAL");
        list = intent.getStringArrayListExtra("LIST");

        for (int i = 0; i < list.size(); i++){
            equations.setText(equations.getText().toString()+list.get(i)+"\n");
        }

        result.setText("Você acertou "+c+" de "+t+" questões");
        if (c.equals(t)){
            message.setText("Parabéns! ");
        } else {
            message.setText("Continue tentando...");
        }

        ok.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PreferenceActivity.class));
            finish();
        });
    }
}