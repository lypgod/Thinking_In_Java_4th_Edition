package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice15;

/**
 * Created by liuyp on 16-10-10.
 */
interface A {
    void a1();

    void a2();
}

interface B {
    void b1();

    void b2();
}

interface C {
    void c1();

    void c2();
}

interface ABC extends A, B, C {
    void c();
}

abstract class D {
    abstract void d();
}

class E extends D implements ABC {

    @Override
    public void a1() {

    }

    @Override
    public void a2() {

    }

    @Override
    public void b1() {

    }

    @Override
    public void b2() {

    }

    @Override
    public void c1() {

    }

    @Override
    public void c2() {

    }

    @Override
    public void c() {

    }

    @Override
    void d() {

    }
}

public class Practice15 {
    static void processA(A a) {

    }

    static void processB(B b) {
    }

    static void processC(C C) {
    }

    static void processABC(ABC abc) {
    }

    static void processD(D d) {
    }

    static void processE(E e) {
    }

    public static void main(String[] args) {
        E e = new E();

        Practice15.processA(e);
        Practice15.processB(e);
        Practice15.processC(e);
        Practice15.processABC(e);
        Practice15.processD(e);
        Practice15.processE(e);

    }
}
