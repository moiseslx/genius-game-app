package com.application.genius.view.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.application.genius.R;

public class DidacticActivity extends AppCompatActivity {
    private Button btnX1, btnX2, btnX3, btnX4, btnX5, btnX6, btnX7, btnX8, btnX9, btnX10, btnCf, btnPc;
    private ImageView btnReturn;
    String mTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didactic);
        startComponents();

        btnX1.setOnClickListener(v -> {
            setTable(1);
        });

        btnX2.setOnClickListener(v -> {
            setTable(2);
        });

        btnX3.setOnClickListener(v -> {
            setTable(3);
        });

        btnX4.setOnClickListener(v -> {
            setTable(4);
        });

        btnX5.setOnClickListener(v -> {
            setTable(5);
        });

        btnX6.setOnClickListener(v -> {
            setTable(6);
        });

        btnX7.setOnClickListener(v -> {
            setTable(7);
        });

        btnX8.setOnClickListener(v -> {
            setTable(8);
        });

        btnX9.setOnClickListener(v -> {
            setTable(9);
        });

        btnX10.setOnClickListener(v -> {
            setTable(10);
        });

        btnCf.setOnClickListener(v -> {

        });

        btnPc.setOnClickListener(v -> {

        });

        btnReturn.setOnClickListener(v -> {
           finish();
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void setTable(int nTable) {
        StringBuilder mTable = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            if (i == 1){
                mTable.append(nTable).append("   ×   ").append(i).append("   =   ").append((nTable * i));
            } else {
                mTable.append("\n").append(nTable).append("   ×   ").append(i).append("   =   ").append((nTable * i));
            }
        }
        this.mTable = String.valueOf(mTable);
        startActivity(new Intent(getApplicationContext(), StudyActivity.class).putExtra("mTABLE", this.mTable));
        finish();
    }

    public void startComponents() {
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

        btnReturn = findViewById(R.id.btnReturnT);
    }
}