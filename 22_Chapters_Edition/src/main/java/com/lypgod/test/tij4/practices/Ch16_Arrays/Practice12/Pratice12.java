package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice12;

import java.util.Arrays;

public class Pratice12 {
    public static void main(String[] args) {
        double[] doubles = new double[3];
        CountingGenerator.Double dGen = new CountingGenerator.Double();
        for(int i = 0; i < doubles.length; i++)
            doubles[i] = dGen.next();
        System.out.println(Arrays.toString(doubles));
    }
}
