package com.application.genius.util;

public class Calculator implements Operations {

    private int n001;
    private int n002;
    private int result;
    char op, opTextView;
    private String format = "";

    public Calculator(int n001, int n002, char op) {
        this.n001 = n001;
        this.n002 = n002;
        this.op = op;
    }

    public Calculator() {
    }

    @Override
    public void plus(Integer n001, Integer n002) {
        Integer result = (n001 + n002);
    }

    @Override
    public void minus(Integer n001, Integer n002) {
        Integer result = (n001 - n002);
    }

    @Override
    public void times(Integer n001, Integer n002) {
        Integer result = (n001 * n002);
    }

    @Override
    public void div(Integer n001, Integer n002) {
        Integer result = (n001 / n002);
    }

    /*------------------------- get and set N001, N002 -------------------------*/
    public int getN001() {
        return n001;
    }

    public void setN001(int n001) {
        this.n001 = n001;
    }

    public int getN002() {
        return n002;
    }

    public void setN002(int n002) {
        this.n002 = n002;
    }
    /*------------------------- get and set N001, N002 -------------------------*/

    /*------------------------- get Result -------------------------*/
    public int getResult() {
        if (op == 'p') {
            result = getN001() + getN002();
        } else if (op == 'm') {
            result = getN001() + getN002();
        } else if (op == 't') {
            result = getN001() * getN002();
        } else if (op == 'd') {
            result = getN001() / getN002();
        }
        return result;
    }
    /*------------------------- get Result -------------------------*/

    /*------------------------- get and set Format -------------------------*/
    public String getFormat() {

        if (op == 'p') {
            opTextView = '+';
        } else if (op == 'm') {
            opTextView = '-';
        } else if (op == 't') {
            opTextView = '×';
        } else if (op == 'd') {
            opTextView = '÷';
        }

        format = (getN001() + " " + opTextView + " " + getN002() + " = " + getResult());
        return format;
    }
    /*------------------------- get and set Format -------------------------*/
}

