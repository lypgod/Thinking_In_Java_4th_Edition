package com.lypgod.test.tij4.practices.Ch2_Object.Practice5;

class DataOnly {
    int i;
    double d;
    boolean b;

    DataOnly() {}

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
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 3;
        dataOnly.d = 1.2345;
        dataOnly.b = false;
        dataOnly.show();
    }
}
