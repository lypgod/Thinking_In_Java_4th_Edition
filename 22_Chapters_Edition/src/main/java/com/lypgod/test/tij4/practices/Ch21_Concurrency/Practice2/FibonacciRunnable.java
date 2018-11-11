package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice2;

/**
 * Created by liuyp on 16-9-27.
 */
public class FibonacciRunnable implements Runnable {
    private String result = "";
    private int length;

    public FibonacciRunnable(int n) {
        length = n;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new FibonacciRunnable(10)).start();
        }
        System.out.println("Starting");
    }

    public void run() {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < length; i++)
            result += gen.next() + " ";
        System.out.println(result);
    }
}
