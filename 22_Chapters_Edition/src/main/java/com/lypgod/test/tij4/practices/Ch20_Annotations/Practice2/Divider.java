//: annotations/Multiplier.java
// APT-based annotation processing.
package com.lypgod.test.tij4.practices.Ch20_Annotations.Practice2;

@ExtractInterface("IDivider")
public class Divider {
    public static void main(String[] args) {
        Divider d = new Divider();
        System.out.println("11/16 = " + d.divide(11, 16));
        System.out.println("10/10 = " + d.divide(10, 10));
        System.out.println("10/1 = " + d.divide(10, 1));
        System.out.println("10/2 = " + d.divide(10, 2));
        System.out.println("10/3 = " + d.divide(10, 3));
        System.out.println("10/0 = " + d.divide(10, 0));
    }

    public int divide(int x, int y) throws ArithmeticException {
        if (y == 0)
            throw new ArithmeticException("Divide by zero");
        int diff = subtract(x, y);
        if (diff < 0)
            return 0;
        if (diff == 0)
            return 1;
        int result = 0;
        while (diff >= 0) {
            result++;
            diff = subtract(diff, y);
        }
        return result;
    }

    private int subtract(int x, int y) {
        return x - y;
    }
}