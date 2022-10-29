package com.application.genius.util;

import android.annotation.SuppressLint;
import android.widget.TextView;

public class Calculator implements Operations{

    RandomNumber randomNumber = new RandomNumber();
    int n001 = randomNumber.getN00();
    int n002 = randomNumber.getN00();
    int result, subResult;
    TextView equation;

    public Calculator(int subResult) {
        this.subResult = subResult;
    }

    /*------------------------- get Result -------------------------*/
    public int getResult() {
        result = multiply(n001,n002);
        return result;
    }
    /*------------------------- get Result -------------------------*/

    /*------------------------- get and set Format -------------------------*/
    @SuppressLint("SetTextI18n")
    public void getFormat(String number) {
        equation.setText((n001) +" "+" × "+" "+ (n002) + " = " + number);
    }

    public void setEquation(TextView equation) {
        this.equation = equation;
    }
    /*------------------------- get and set Format -------------------------*/

    @Override
    public int multiply(Integer n001, Integer n002) {
        return n001 * n002;
    }
}

