package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice5;

/**
 * Created by liuyp on 16-10-11.
 */
class Outer {
    class Inner {
        void print() {
            System.out.println("Inner");
        }
    }
}
public class InnerClassTest {
    public static void main(String[] args) {
        new Outer().new Inner().print();
    }
}
