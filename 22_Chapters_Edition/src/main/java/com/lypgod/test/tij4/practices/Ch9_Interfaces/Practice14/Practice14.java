package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice14;

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

class D {
    void d() {
    }
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
}

public class Practice14 {
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
        D d = new D();
        E e = new E();

        Practice14.processA(e);
        Practice14.processB(e);
        Practice14.processC(e);
        Practice14.processABC(e);
        Practice14.processD(e);
        Practice14.processE(e);

    }
}
