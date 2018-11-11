package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice6;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class Practice6 {
    public static BerylliumSphere[][] sphereAM(int size1, int size2) {
        BerylliumSphere[][] result = new BerylliumSphere[size1][size2];
        for (int i = 0; i < size1; i++) {
            result[i] = new BerylliumSphere[size2];
            for (int j = 0; j < size2; j++)
                result[i][j] = new BerylliumSphere();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sphereAM(2, 2)));
    }
}
