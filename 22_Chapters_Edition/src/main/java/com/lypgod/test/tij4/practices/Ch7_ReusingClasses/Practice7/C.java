package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice7;

class A {
    A(int i) {
        System.out.println("A init: " + i);
    }
}

class B {
    B(int i) {
        System.out.println("B init: " + i);
    }
}

public class C extends A {
    C(int i) {
        super(i);
        B b = new B(i);
        System.out.println("C init: " + i);
    }

    public static void main(String[] args) {
        C c = new C(1);
    }
}
