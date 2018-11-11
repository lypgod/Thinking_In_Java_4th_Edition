package com.lypgod.test.tij4.practices.Ch4_ControllingExecution.Practice3;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        int i1 = random.nextInt(10);
        int i2 = -1;
        while (i1 != i2) {
            if (i1 < i2) {
                System.out.println("i1:" + i1 + " Less Than i2:" + i2);
            } else if (i1 > i2) {
                System.out.println("i1:" + i1 + " Greater Than i2:" + i2);
            } else {
                System.out.println("i1:" + i1 + " Equals To i2:" + i2);
            }
            i1 = i2;
            i2 = random.nextInt(10);
        }
    }
}
