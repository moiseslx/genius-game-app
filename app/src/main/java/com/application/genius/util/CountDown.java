package com.application.genius.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;

import android.widget.TextView;

public class CountDown extends CountDownTimer {

    private final TextView countDownView;
    private long millisInFuture;
    Context context;

    public CountDown(long millisInFuture, long countDownInterval, Context context, TextView countDownView) {
        super(millisInFuture, countDownInterval);
        this.context = context;
        this.countDownView = countDownView;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTick(long l) {
        this.millisInFuture = l;
        countDownView.setText(" "+getTimeFormat()+" ");
    }

    @Override
    public void onFinish() {
    }

    private String getTimeFormat() {
        String timeFormat;
        timeFormat = String.valueOf((getMillisInFuture() / 1000L));
        return timeFormat;
    }

    public long getMillisInFuture() {
        return millisInFuture;
    }
}
