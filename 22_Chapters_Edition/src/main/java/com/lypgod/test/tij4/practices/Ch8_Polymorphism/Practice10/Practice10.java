package com.lypgod.test.tij4.practices.Ch8_Polymorphism.Practice10;

/**
 * Created by liuyp on 16-10-9.
 */
class Base {
    void method1() {
        System.out.println("Base method1.");
        method2();
    }
    void method2() {
        System.out.println("Base method2");
    }
}
class Extended extends Base {
    @Override
    void method2() {
        System.out.println("Extended method2.");
    }
}
public class Practice10 {
    public static void main(String[] args) {
        Base base = new Extended();
        base.method1();
    }
}
