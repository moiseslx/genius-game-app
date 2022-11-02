package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.genius.R;

import java.util.ArrayList;

public class DidacticActivity extends AppCompatActivity {
    private Button btnX1, btnX2, btnX3, btnX4, btnX5, btnX6, btnX7, btnX8, btnX9, btnX10, btnCf, btnPc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didactic);
        startComponents();


        btnX1.setOnClickListener(v -> {

        });

        btnX2.setOnClickListener(v -> {

        });

        btnX3.setOnClickListener(v -> {

        });

        btnX4.setOnClickListener(v -> {

        });

        btnX5.setOnClickListener(v -> {

        });

        btnX6.setOnClickListener(v -> {

        });

        btnX7.setOnClickListener(v -> {

        });

        btnX8.setOnClickListener(v -> {

        });

        btnX9.setOnClickListener(v -> {

        });

        btnX10.setOnClickListener(v -> {

        });

        btnCf.setOnClickListener(v -> {

        });

        btnPc.setOnClickListener(v -> {

        });
    }

    public void startComponents(){
        btnX1 = findViewById(R.id.btnX1);
        btnX2 = findViewById(R.id.btnX2);
        btnX3 = findViewById(R.id.btnX3);
        btnX4 = findViewById(R.id.btnX4);
        btnX5 = findViewById(R.id.btnX5);
        btnX6 = findViewById(R.id.btnX6);
        btnX7 = findViewById(R.id.btnX7);
        btnX8 = findViewById(R.id.btnX8);
        btnX9 = findViewById(R.id.btnX9);
        btnX10 = findViewById(R.id.btnX10);

        btnCf = findViewById(R.id.btnCF);
        btnPc = findViewById(R.id.btnPC);
    }
}