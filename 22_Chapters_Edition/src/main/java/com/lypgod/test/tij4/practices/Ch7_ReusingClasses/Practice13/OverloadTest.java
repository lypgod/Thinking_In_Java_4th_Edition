package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice13;

/**
 * Created by liuyp on 16-10-8.
 */
class Base {
    void print() {
        System.out.println("Base print");
    }

    void print(String s) {
        System.out.println("Base print String " + s);
    }

    void print(int s) {
        System.out.println("Base print int " + s);
    }

    void print(double s) {
        System.out.println("Base print double " + s);
    }
}
public class OverloadTest extends Base{


    void print(boolean s) {
        System.out.println("Base print boolean " + s);
    }

    public static void main(String[] args) {
        OverloadTest overloadTest = new OverloadTest();
        overloadTest.print();
        overloadTest.print("SSS");
        overloadTest.print(1);
        overloadTest.print(1.2);
        overloadTest.print(true);
    }
}
