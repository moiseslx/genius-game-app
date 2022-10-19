package com.application.genius.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

import android.widget.TextView;
import android.widget.Toast;

import com.application.genius.view.game.PreferenceActivity;

public class CountDown extends CountDownTimer {

    private TextView countDownView;
    private Context context;
    private long millisInFuture;

    public CountDown(long millisInFuture, long countDownInterval, Context context, TextView countDownView) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.countDownView = countDownView;
    }

    @Override
    public void onTick(long l) {
        this.millisInFuture = l;
        countDownView.setText(getTimeFormat());


        if (countDownView.getText().toString().equals("0")) {
            onFinish();
            new Activity().startActivity(new Intent(context, PreferenceActivity.class));
        }

    }

    @Override
    public void onFinish() {
        try {
            finalize();
        } catch (Throwable e) {
            e.printStackTrace();
            Toast.makeText(context, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    private String getTimeFormat() {
        String timeFormat;
        timeFormat = String.valueOf(getMillisInFuture() / 1000L);
        return timeFormat;
    }

    public long getMillisInFuture() {
        return millisInFuture;
    }
}
