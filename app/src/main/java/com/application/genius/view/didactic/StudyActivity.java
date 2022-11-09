package com.application.genius.view.didactic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.genius.R;
import com.application.genius.view.didactic.DidacticActivity;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        ImageView btnReturn = findViewById(R.id.btnReturn0);
        TextView mTableView = findViewById(R.id.textViewTable);

        Intent i = getIntent();
        String mTable = i.getStringExtra("mTABLE");
        mTableView.setText(mTable);
        btnReturn.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), DidacticActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), DidacticActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}