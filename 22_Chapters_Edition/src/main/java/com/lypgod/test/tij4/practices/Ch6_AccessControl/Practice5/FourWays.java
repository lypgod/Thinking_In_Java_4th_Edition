package com.lypgod.test.tij4.practices.Ch6_AccessControl.Practice5;

public class FourWays {
    int a = 0;
    public int b = 1;
    protected int c = 2;
    private int d = 3;

    FourWays() {
        System.out.println("FourWays() constructor");
    }

    void showa() {
        System.out.println(a);
    }

    public void showb() {
        System.out.println(b);
    }

    protected void showc() {
        System.out.println(c);
    }

    private void showd() {
        System.out.println(d);
    }
}
