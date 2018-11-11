package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice6;

import java.util.Random;

public class Practice6 implements Runnable {
    private static int idIndex = 0;
    private final int id = idIndex++;
    private int sleepTime = (new Random().nextInt(10)) * 1000;

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#" + id + ": " + sleepTime);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Practice6()).start();
        }
    }
}
