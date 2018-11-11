package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Practice23 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] integers = new Integer[10];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }
}
