package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.application.genius.R;

import java.util.Objects;

public class PracticeActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnClear;
    private Button btnSub;
    private TextView equation;
    String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        startComponents();

        equation.setText(number);

        keyboard();
    }

    public void startComponents() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnClear = findViewById(R.id.btnClear);

        equation = findViewById(R.id.textViewEquation);

        btnSub = findViewById(R.id.btnSub);
    }

    public void keyboard (){
        btn1.setOnClickListener(view -> {
            number = number + "1";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn2.setOnClickListener(view -> {
            number = number + "2";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn3.setOnClickListener(view -> {
            number = number + "3";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn4.setOnClickListener(view -> {
            number = number + "4";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn5.setOnClickListener(view -> {
            number = number + "5";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn6.setOnClickListener(view -> {
            number = number + "6";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn7.setOnClickListener(view -> {
            number = number + "7";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn8.setOnClickListener(view -> {
            number = number + "8";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn9.setOnClickListener(view -> {
            number = number + "9";
            equation.setText(number);
            btnClear.setVisibility(View.VISIBLE);
        });

        btn0.setOnClickListener(view -> {

            if (!Objects.equals(number, "")) {
                number = number + "0";
                btnClear.setVisibility(View.VISIBLE);
            } else {
                number = "";
            }
            equation.setText(number);

        });

        btnClear.setOnClickListener(view -> {
            try {
                int i = number.length() - 1;
                number = String.valueOf(new StringBuilder(number).deleteCharAt(i));
                equation.setText(number);
            } catch (Exception e) {
                number = "";
            }
        });

        btnSub.setOnClickListener(view -> {

        });
    }
}