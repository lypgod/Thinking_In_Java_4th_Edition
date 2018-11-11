package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice3;

/**
 * Created by liuyp on 16-10-11.
 */

public class InnerClassTest {
    private String s;

    InnerClassTest() {
        s = "Outer.";
    }

    class Inner {
        void printS() {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        InnerClassTest outer = new InnerClassTest();
        outer.new Inner().printS();
    }
}
