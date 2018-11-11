package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice1;

/**
 * Created by liuyp on 16-9-27.
 */
public class LiftOff implements Runnable {
    private static int idIndex = 0;
    private final int id = idIndex++;

    public LiftOff() {
        System.out.println("#" + id + ": Constructed.");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Starting");
    }

    public void run() {
        System.out.println("#" + id + ": First message.");
        Thread.yield();
        System.out.println("#" + id + ": Second message.");
        Thread.yield();
        System.out.println("#" + id + ": Third message.");
        Thread.yield();
        System.out.println("#" + id + ": Finished.");
    }
}
