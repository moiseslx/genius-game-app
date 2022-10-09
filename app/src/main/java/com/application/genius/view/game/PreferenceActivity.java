package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.application.genius.R;

public class PreferenceActivity extends AppCompatActivity {

    private Button plus, minus, times, div, init;
    private EditText goal;
    private SeekBar seekBar;
    private TextView timeView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);


        /* plus == adição
         * minus == subtração
         * times == multiplicação
         * div == divisão
         * */

        startComponents();

        String goalN = goal.getText().toString();

        timeView.setText("30");

        char[] selectOp = new char[4];
        String time = timeView.getText().toString();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectOp[0] = 'p';
                Log.i("Op", "Selected " + plus.toString());
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectOp[1] = 'm';
                Log.i("Op", "Selected " + minus.toString());
            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectOp[2] = 't';
                Log.i("Op", "Selected " + times.toString());
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectOp[3] = 'd';
                Log.i("Op", "Selected " + div.toString());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                timeView.setText(progress + "0");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PracticeActivity.class);
                intent.putExtra("OP", selectOp); //Opções + - / *
                intent.putExtra("GOAL", goalN); //Meta de acerto
                intent.putExtra("SECOND", time); //Tempo de resposta

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void startComponents() {

        /*OPERAÇÕES*/
        plus = findViewById(R.id.btnPlus);
        minus = findViewById(R.id.btnMinus);
        times = findViewById(R.id.btnTimes);
        div = findViewById(R.id.btnDiv);

        /*BOTÃO DE INICIO*/
        init = findViewById(R.id.btnInit);

        /*META*/
        goal = findViewById(R.id.editTextNumberGoal);

        /*TEMPO DE RESPOSTA*/
        timeView = findViewById(R.id.textViewTime);

        /*SEEKBAR*/
        seekBar = findViewById(R.id.seekBar);
    }

}