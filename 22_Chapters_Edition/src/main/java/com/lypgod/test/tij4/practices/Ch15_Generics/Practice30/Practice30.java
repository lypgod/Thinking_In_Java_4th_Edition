package com.lypgod.test.tij4.practices.Ch15_Generics.Practice30;

public class Practice30 {
    public static void main(String[] args) {
        Holder<Integer> intHolder = new Holder<>();

        intHolder.set(1);
        System.out.println(intHolder.get() + ". ");
        System.out.println(intHolder.get().getClass());
        int i = intHolder.get();
        System.out.println("int i = intHolder.get() = " + i);
    }
}
