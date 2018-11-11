package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice19;

import java.util.Arrays;

class A {
    private int i;

    A(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof A && this.i == ((A) obj).i;
    }
}

public class Practice19 {
    public static void main(String[] args) {
        A[] a1 = { new A(1), new A(2), new A(3) };
        A[] a2 = { new A(1), new A(2), new A(3) };
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.equals(a1, a2));
    }
}
