package com.lypgod.test.tij4.practices.Ch2_Object.Practice3;

class ATypeName {
    int i;
    double d;
    boolean b;

    ATypeName(int i, double d, boolean b) {
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

public class ATypeNameTest {
    public static void main(String[] args) {
        ATypeName aTypeName = new ATypeName(3, 0.3, false);
        aTypeName.show();
    }
}
