package com.lypgod.test.tij4.practices.Ch15_Generics.Practice9;//: generics/GenericMethods.java

public class GenericMethods {
    public <T, E, U> void f(T t, E e, U u) {
        System.out.println(t.getClass().getName() + ", " + e.getClass().getName() + ", " + u.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1.0);
        gm.f(1.0F, 'c', gm);
    }
}
