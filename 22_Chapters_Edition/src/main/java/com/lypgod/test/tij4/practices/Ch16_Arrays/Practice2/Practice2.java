package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice2;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}
public class Practice2 {
    static BerylliumSphere[] test(int size) {
        BerylliumSphere[] result = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            result[i] = new BerylliumSphere();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(test(5)));
    }
}
