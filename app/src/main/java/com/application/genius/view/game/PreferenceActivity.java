package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.application.genius.R;

public class PreferenceActivity extends AppCompatActivity {

    private Button init, btnP, btnM;
    private int goal, time;
    private SeekBar seekBar;
    private TextView timeView, goalView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        startComponents();

        timeView.setText("30s");
        time = 30;
        setGoal();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                timeView.setText(progress + "0s");
                time = progress * 10;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PracticeActivity.class);
                intent.putExtra("GOAL", goal);
                intent.putExtra("SECOND", time);

                startActivity(intent);
                finish();
            }
        });


    }

    private void startComponents() {
        init = findViewById(R.id.btnInit);
        timeView = findViewById(R.id.textViewTime);
        seekBar = findViewById(R.id.seekBar);
        goalView = findViewById(R.id.textViewGoal);
        btnP = findViewById(R.id.btnP);
        btnM = findViewById(R.id.btnM);
    }

    private void setGoal(){
        goal = 10;
        btnM.setOnClickListener(view -> {
            goal--;
            goalUpdate();
        });

        btnP.setOnClickListener(view -> {
            goal++;
            goalUpdate();
        });
            init.setVisibility(View.VISIBLE);
    }

    private void goalUpdate(){
        goalView.setText(String.valueOf(goal));
        if (goal >= 30){
            goal = 30;
            goalView.setText(String.valueOf(goal));
        } else if (goal <= 5){
            goal = 5;
            goalView.setText(String.valueOf(goal));
        }
    }

}