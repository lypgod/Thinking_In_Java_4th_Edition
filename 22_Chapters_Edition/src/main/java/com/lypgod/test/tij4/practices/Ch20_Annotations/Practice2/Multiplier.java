//: annotations/Multiplier.java
// APT-based annotation processing.
package com.lypgod.test.tij4.practices.Ch20_Annotations.Practice2;

@ExtractInterface("IMultiplier")
public class Multiplier {
    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11*16 = " + m.multiply(11, 16));
    }

    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++)
            total = add(total, y);
        return total;
    }

    private int add(int x, int y) {
        return x + y;
    }
} /* Output:
11*16 = 176
*///:~
