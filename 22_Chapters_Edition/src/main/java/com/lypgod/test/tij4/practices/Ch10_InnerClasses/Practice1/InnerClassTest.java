package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice1;

/**
 * Created by liuyp on 16-10-11.
 */

public class InnerClassTest {
    class Inner {
        void print() {
            System.out.println("Inner.");
        }
    }

    Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        InnerClassTest outer = new InnerClassTest();
        Inner inner = outer.getInner();
        inner.print();
    }
}
