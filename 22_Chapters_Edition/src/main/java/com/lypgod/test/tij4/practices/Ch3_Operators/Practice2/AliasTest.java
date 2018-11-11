package com.lypgod.test.tij4.practices.Ch3_Operators.Practice2;

class Tank {
    float f;
}

public class AliasTest {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.f = 0.123f;
        t2.f = 1.234f;
        System.out.println("t1.f = " + t1.f);
        System.out.println("t2.f = " + t2.f);
        t1.f = t2.f;
        System.out.println("t1.f = " + t1.f);
        System.out.println("t2.f = " + t2.f);
        t1.f = 0.1234f;
        System.out.println("t1.f = " + t1.f);
        System.out.println("t2.f = " + t2.f);
        t1 = t2;
        System.out.println("t1.f = " + t1.f);
        System.out.println("t2.f = " + t2.f);
        t1.f = 0.1234f;
        System.out.println("t1.f = " + t1.f);
        System.out.println("t2.f = " + t2.f);
    }
}
