package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice5;

class A {
    A() {
        System.out.println("A init");
    }
}

class B {
    B() {
        System.out.println("B init.");
    }
}

public class C extends A {
    B b = new B();

    public static void main(String[] args) {
        C c = new C();
    }
}
