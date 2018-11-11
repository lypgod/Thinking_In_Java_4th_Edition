package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice10;

public class FibonacciTest {
    private String result = "";
    private int length;
    private Thread t;

    public FibonacciTest(int n) {
        length = n;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new FibonacciTest(10).runTask();
        }
    }

    public void runTask() {
        if (t == null) {
            t = new Thread() {
                public void run() {
                    Fibonacci gen = new Fibonacci();
                    for (int i = 0; i < length; i++)
                        result += gen.next() + " ";
                    System.out.println(this);
                }

                public String toString() {
                    return getName() + ": " + result;
                }
            };
            t.start();
        }
    }
}
