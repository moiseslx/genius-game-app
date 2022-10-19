package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.application.genius.R;
import com.application.genius.util.Calculator;
import com.application.genius.util.CountDown;
import com.application.genius.view.MainActivity;
import com.application.genius.view.fragments.HomeFragment;

import java.util.Objects;

public class PracticeActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnClear;
    private Button btnSub;

    private TextView equation;

    private int n001, n002;
    private Calculator calculator;

    String op, time, goal;
    char opRandom;

    String number = "";
    int numberInt = 0;

    CountDown countDown;
    TextView countDownView;
    private final long INTERVAL = 1000;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        startComponents();

        keyboard();

        Intent i = getIntent();

        op = i.getStringExtra("OP");
        time = i.getStringExtra("SECOND");
        goal = i.getStringExtra("GOAL");

        countDown = new CountDown(Long.parseLong(time) * INTERVAL, INTERVAL, getApplicationContext(), countDownView);
        countDown.start();

        opRandom = op.charAt((int) (Math.random() * op.length()));

        n001 = randomNumber001(opRandom);
        n002 = randomNumber002(opRandom);

        calculator = new Calculator(n001, n002, opRandom, numberInt);
        equation.setText(calculator.getFormat() + number);


        btnSub.setOnClickListener(view -> {
            if (numberInt == calculator.getResult()) {
                Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT).show();
                opRandom = op.charAt((int) (Math.random() * op.length()));
                n001 = randomNumber001(this.opRandom);
                n002 = randomNumber002(this.opRandom);
                number = "";
                calculator = new Calculator(n001, n002, opRandom, numberInt);

                countDown.cancel();
                countDown.start();

                equation.setText(calculator.getFormat() + number);

            } else {
                Toast.makeText(getApplicationContext(), "INCORRECT", Toast.LENGTH_SHORT).show();
            }
        });

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

        countDownView = findViewById(R.id.textViewTime);
    }

    @SuppressLint("SetTextI18n")
    public void keyboard() {
        btn1.setOnClickListener(view -> {
            number = number + "1";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn2.setOnClickListener(view -> {
            number = number + "2";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn3.setOnClickListener(view -> {
            number = number + "3";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn4.setOnClickListener(view -> {
            number = number + "4";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn5.setOnClickListener(view -> {
            number = number + "5";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn6.setOnClickListener(view -> {
            number = number + "6";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn7.setOnClickListener(view -> {
            number = number + "7";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn8.setOnClickListener(view -> {
            number = number + "8";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn9.setOnClickListener(view -> {
            number = number + "9";
            numberInt = Integer.parseInt(number);
            equation.setText(calculator.getFormat() + (number));
            btnClear.setVisibility(View.VISIBLE);
        });

        btn0.setOnClickListener(view -> {

            if (!Objects.equals(number, "") || opRandom == 'm') {
                number = number + "0";
                btnClear.setVisibility(View.VISIBLE);
                numberInt = Integer.parseInt(number);
            } else {
                number = "";
            }
            equation.setText(calculator.getFormat() + (number));

        });

        btnClear.setOnClickListener(view -> {
            try {
                int i = number.length() - 1;
                number = String.valueOf(new StringBuilder(number).deleteCharAt(i));
                equation.setText(calculator.getFormat() + (number));
            } catch (Exception e) {
                number = "";
            }
        });
    }

    /*Gerar classe*/
    public int randomNumber001(char opRandom) {
        int r = 0;
        if (opRandom == 'p') {
            r = (int) (Math.random() * (10 - 1)) + 1;
        } else if (opRandom == 't') {
            r = (int) (Math.random() * (10 - 1)) + 1;
        } else if (opRandom == 'm') {
            r = (int) ((Math.random() * (10 - 5)) + 5);
        } else if (opRandom == 'd') {
            r = 1 + (int) (Math.random() * 10) + 1;
        }
        return r;
    }

    public int randomNumber002(char opRandom) {
        int r = 0;
        if (opRandom == 'p') {
            r = 1 + (int) (Math.random() * 10);
        } else if (opRandom == 't') {
            r = 1 + (int) (Math.random() * 10);
        } else if (opRandom == 'm') {
            r = (int) ((Math.random() * (5 - 1)) + 1);
        } else if (opRandom == 'd') {
            r = 1 + (int) (Math.random() * 10);
        }
        return r;
    }
}