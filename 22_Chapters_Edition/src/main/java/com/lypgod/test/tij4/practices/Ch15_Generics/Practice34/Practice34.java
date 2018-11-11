package com.lypgod.test.tij4.practices.Ch15_Generics.Practice34;

abstract class SelfBoundedType<T extends SelfBoundedType<T>> {
    abstract T f(T t);
    T g(T t) {
        System.out.println("SelfBoundedType - " + t);
        return t;
    }
}

class D extends SelfBoundedType<D> {
    D f(D arg) {
        System.out.println("f(D arg)");
        return arg;
    }
}
public class Practice34 {
    public static void main(String[] args) {
        D d = new D();
        d.f(d).g(d);
    }
}
