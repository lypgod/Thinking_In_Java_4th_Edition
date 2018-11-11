package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice4;

import java.util.Arrays;

public class Practice4 {
    static double[][] createArray(int size1, int size2, double start, double end) {
        if (!(start < end)) {
            System.out.println("Start must be less than end");
            return null;
        }
        if ((size1 < 1) || (size2 < 1)) {
            System.out.println("Size must be > 0");
            return null;
        }
        double[][] result = new double[size1][size2];
        result[0] = new double[size2];
        for (int j = 0; j < size2; j++) {
            result[0][j] = (start + ((double) j / (size2 - 1)) * (end - start));
        }
        if (size1 == 1) {
            return result;
        } else {
            for (int i = 1; i < size1; i++) {
                result[i] = new double[size2];
                for (int j = 0; j < size2; j++) {
                    result[i][j] = start +
                            ((double) j / (size2 - 1)) * (((double) j + (double) i) / (size2 - 1 + i)) * (end - start);
                }
            }
        }
        return result;
    }

    static double[][][] create3Array(int size1, int size2, int size3,
                                     double start, double end) {
        if (!(start < end)) {
            System.out.println("Start must be less than end");
            return null;
        }
        if ((size1 < 1) || (size2 < 1) || (size3 < 1)) {
            System.out.println("Size must be > 0");
            return null;
        }
        double[][][] result = new double[size1][size2][size3];
        for (int i = 0; i < size1; i++)
            result[i] = createArray(size2, size3, start, end);
        return result;
    }

    static void print3Array(double[][][] da) {
        System.out.println(Arrays.deepToString(da));
    }

    public static void main(String[] args) {
        print3Array(create3Array(0, 2, 3, 4, 5));
        print3Array(create3Array(2, 3, 3, 5, 4));
        print3Array(create3Array(1, 2, 2, 5, 10));
        print3Array(create3Array(2, 2, 3, 5, 10));
        print3Array(create3Array(3, 3, 3, 5, 10));
        print3Array(create3Array(3, 5, 5, 10, 20));
    }
}
