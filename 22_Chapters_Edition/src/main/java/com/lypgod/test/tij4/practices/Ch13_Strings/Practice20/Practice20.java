package com.lypgod.test.tij4.practices.Ch13_Strings.Practice20;

import java.util.Scanner;

public class Practice20 {
    int i;
    long L;
    float f;
    double d;
    String s;

    Practice20(String s) {
        Scanner sc = new Scanner(s);
        i = sc.nextInt();
        L = sc.nextLong();
        f = sc.nextFloat();
        d = sc.nextDouble();
        this.s = sc.next();
    }

    public String toString() {
        return i + " " + L + " " + f + " " + d + " " + s;
    }

    public static void main(String[] args) {
        Practice20 s20 = new Practice20("17 56789 2.7 3.61412 hello");
        System.out.println(s20);
    }
}
