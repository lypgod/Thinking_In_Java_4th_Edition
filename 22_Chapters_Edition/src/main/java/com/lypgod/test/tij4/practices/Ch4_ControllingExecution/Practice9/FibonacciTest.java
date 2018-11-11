package com.lypgod.test.tij4.practices.Ch4_ControllingExecution.Practice9;

public class FibonacciTest {
    private static int getNext(int i1, int i2) {
        return i1 + i2;
    }

    private static String Fibonacci(int length) {
        int current = 1;
        int next = 1;
        int tmp;
        int counter = 2;
        String result = "1 1 ";
        while (counter < length) {
            tmp = getNext(current, next);
            current = next;
            next = tmp;
            result += next + " ";
            counter++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }
}
