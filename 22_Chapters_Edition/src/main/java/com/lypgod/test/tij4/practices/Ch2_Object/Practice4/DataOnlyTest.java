package com.lypgod.test.tij4.practices.Ch2_Object.Practice4;

class DataOnly {
    int i;
    double d;
    boolean b;

    DataOnly(int i, double d, boolean b) {
        this.i = i;
        this.d = d;
        this.b = b;
    }

    void show() {
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
    }
}

public class DataOnlyTest {
    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly(3, 2.143, true);
        dataOnly.show();
    }
}
