package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice7;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class Practice7 {
    public static BerylliumSphere[][][] sphereAM(int size1, int size2, int size3) {
        BerylliumSphere[][][] result = new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            result[i] = new BerylliumSphere[size2][size3];
            for (int j = 0; j < size2; j++) {
                result[i][j] = new BerylliumSphere[size3];
                for (int k = 0; k < size3; k++) {
                    result[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sphereAM(2, 2, 2)));
    }
}
