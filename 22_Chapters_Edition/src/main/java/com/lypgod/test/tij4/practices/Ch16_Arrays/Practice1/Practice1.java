package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice1;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}
public class Practice1 {
    public static void test(BerylliumSphere[] a) {
        System.out.println(Arrays.asList(a));
    }

    public static void main(String[] args) {
        test(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});
    }
}
