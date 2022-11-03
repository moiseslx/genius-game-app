package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.application.genius.R;
import com.application.genius.util.Calculator;
import com.application.genius.util.CountDown;
import com.application.genius.view.RegisterActivity;

import java.util.ArrayList;
import java.util.Objects;

public class PracticeActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnClear, btnSub;

    private TextView equation, textViewGoal;

    private Calculator calculator;

    ArrayList<String> results = new ArrayList<>();

    int time, goal;

    int n = 0, s = 0;

    String number = "";
    Integer numberInt = 0;

    CountDown countDown;
    TextView countDownView;
    final long INTERVAL = 1000;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        startComponents();

        keyboard();

        Intent i = getIntent();
        time = i.getIntExtra("SECOND", 30);
        goal = i.getIntExtra("GOAL", 10);
        cycle();

        btnSub.setOnClickListener(view -> {
            if (numberInt == calculator.getResult()) {
                Toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT).show();
                number = "";
                countDown.cancel();
                s++;
                textViewGoal.setText(" "+s + " | " + n+" ");
                checker();
                cycle();
            } else {
                if (!number.equals("")){
                    Toast.makeText(getApplicationContext(), "INCORRECT", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        countDown.cancel();
    }

    public void checker() {
        if (s + n == goal) {
            equation.setVisibility(View.INVISIBLE);
            countDownView.setVisibility(View.INVISIBLE);
            countDown.cancel();
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("TOTAL", String.valueOf(goal));
            intent.putExtra("CORRECT", String.valueOf(s));
            intent.putStringArrayListExtra("LIST", results);
            startActivity(intent);
            finish();
        }
    }

    public void cycle() {
        calculator = new Calculator(numberInt);
        calculator.setEquation(equation);
        calculator.getFormat(number);
        results.add(calculator.getResultFormat());
        countDown = new CountDown(time * INTERVAL, INTERVAL, getApplicationContext(), countDownView) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                super.onFinish();
                calculator = new Calculator(numberInt);
                results.add(calculator.getResultFormat());
                number = "";
                numberInt = 0;
                calculator.setEquation(equation);
                calculator.getFormat(number);
                n++;
                textViewGoal.setText(s + " | " + n);
                checker();
                countDown.start();
            }
        };
        countDown.start();
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

        textViewGoal = findViewById(R.id.goal);
    }

    public void keyboard() {

        btn1.setOnClickListener(view -> {
            setNumber("1");
        });

        btn2.setOnClickListener(view -> {
            setNumber("2");
        });

        btn3.setOnClickListener(view -> {
            setNumber("3");
        });

        btn4.setOnClickListener(view -> {
            setNumber("4");
        });

        btn5.setOnClickListener(view -> {
            setNumber("5");
        });

        btn6.setOnClickListener(view -> {
            setNumber("6");
        });

        btn7.setOnClickListener(view -> {
            setNumber("7");
        });

        btn8.setOnClickListener(view -> {
            setNumber("8");
        });

        btn9.setOnClickListener(view -> {
            setNumber("9");
        });

        btn0.setOnClickListener(view -> {

            if (!Objects.equals(number, "")) {
                setNumber("0");
            } else {
                number = "";
                calculator.getFormat(number);
            }
        });

        btnClear.setOnClickListener(view -> {
            try {
                int i = number.length() - 1;
                number = String.valueOf(new StringBuilder(number).deleteCharAt(i));
                calculator.getFormat(number);
            } catch (Exception e) {
                number = "";
            }
        });
    }

    public void setNumber(String n) {
        if (number.length() >= 3) {
            numberInt = Integer.parseInt(number);
            calculator.getFormat(number);
        } else {
            number = number + n;
            numberInt = Integer.parseInt(number);
            calculator.getFormat(number);
            btnClear.setVisibility(View.VISIBLE);
        }
    }
}