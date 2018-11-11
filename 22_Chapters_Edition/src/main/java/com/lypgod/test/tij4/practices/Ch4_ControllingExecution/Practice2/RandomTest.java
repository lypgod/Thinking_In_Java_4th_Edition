package com.lypgod.test.tij4.practices.Ch4_ControllingExecution.Practice2;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        int i1 = random.nextInt();
        int i2;
        for (int i = 0; i < 25; i++) {
            i2 = random.nextInt();
            if (i1 < i2) {
                System.out.println("i1:" + i1 + " Less Than i2:" + i2);
            } else if (i1 > i2) {
                System.out.println("i1:" + i1 + " Greater Than i2:" + i2);
            } else {
                System.out.println("i1:" + i1 + " Equals To i2:" + i2);
            }
            i1 = i2;
        }
    }
}
