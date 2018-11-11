package com.lypgod.test.tij4.practices.Ch15_Generics.Practice10;//: generics/GenericMethods.java

public class GenericMethods {
    public <T, E> void f(T t, String s, E e) {
        System.out.println(t.getClass().getName() + ", " + s + ", " + e.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f(1, "aaa", 1.0);
        gm.f(1.0F, "c", gm);
    }
}
