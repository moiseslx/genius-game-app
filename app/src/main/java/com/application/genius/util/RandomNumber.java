package com.application.genius.util;

public class RandomNumber {
    protected int n00;

    public int getN00(){
        n00 = 1 + (int) (Math.random() * 10);
        return n00;
    }
}
