package com.lypgod.test.tij4.practices.Ch15_Generics.Practice2;
class ClassA {
    @Override
    public String toString() {
        return "ClassA";
    }
}
class ClassB {
    @Override
    public String toString() {
        return "ClassB";
    }
}
class ClassC {
    @Override
    public String toString() {
        return "ClassC";
    }
}
public class MyHolder<A, B, C> {
    private A a;
    private B b;
    private C c;

    public MyHolder(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return a + ", " + b + ", " + c;
    }

    public static void main(String[] args) {
        MyHolder<ClassB, ClassA, ClassC> holder = new MyHolder<>(new ClassB(), new ClassA(), new ClassC());
        System.out.println(holder);
    }
}
