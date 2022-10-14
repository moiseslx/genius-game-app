package com.application.genius.util;

public class Calculator implements Operations {

    int n001;
    int n002;
    private int result;
    int subResult;
    char op, opTextView;
    String format;

    public Calculator(int n001, int n002,char op,int subResult) {
        this.n001 = n001;
        this.n002 = n002;
        this.op = op;
        this.subResult = subResult;
    }

    /*------------------------- get Result -------------------------*/
    public int getResult() {
        if (op == 'p') {
            result = plus(n001,n002);
        } else if (op == 'm') {
            result = minus(n001,n002);
        } else if (op == 't') {
            result = times(n001,n002);
        } else if (op == 'd') {
            result = div(n001,n002);;
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

        format = (((n001) +" "+opTextView+" "+ (n002) + " = "));
        return format;
    }
    /*------------------------- get and set Format -------------------------*/

    @Override
    public int plus(Integer n001, Integer n002) {
        return result = (n001 + n002);
    }

    @Override
    public int minus(Integer n001, Integer n002) {
        return result = (n001 - n002);
    }

    @Override
    public int times(Integer n001, Integer n002) {
        return result = (n001 * n002);
    }

    @Override
    public int div(Integer n001, Integer n002) {
        return result = (n001 / n002);
    }
}

