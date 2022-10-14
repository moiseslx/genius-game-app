package com.application.genius.util;

import android.os.CountDownTimer;

public class CountDown extends Thread {

    private CountDownTimer countDownTimer;
    private int millisInFuture;
    private String countDownView;

    public CountDown(CountDownTimer countDownTimer, int millisInFuture) {
        this.countDownTimer = countDownTimer;
        this.millisInFuture = millisInFuture;
    }


    public void run(int millisInFuture) {
        this.millisInFuture = millisInFuture;
        countDownTimer = new CountDownTimer(millisInFuture * 1000L, 1000) {

            public void onTick(long millisUntilFinished) {
                countDownView = (String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
            }
        }.start();
    }

    private String getFormat(){
        return countDownView;
    }
}
