package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice15;

/**
 * Created by liuyp on 16-10-12.
 */
class Class1 {
    Class1(int i) {}
    void print() {
        System.out.println("Class1.");
    }
}
class Class2 {
    Class1 getClass1 (int i) {
        return new Class1(i) {
        };
    }
}
public class Practice15 {
    public static void main(String[] args) {
        new Class2().getClass1(1).print();
    }
}
