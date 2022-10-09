package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.application.genius.R;
import com.application.genius.util.Calculator;

public class PracticeActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        /*Test*/
        t = findViewById(R.id.textViewEquation);

        Calculator calculator = new Calculator(100, 100, 'p');

        t.setText(calculator.getFormat());
    }
}