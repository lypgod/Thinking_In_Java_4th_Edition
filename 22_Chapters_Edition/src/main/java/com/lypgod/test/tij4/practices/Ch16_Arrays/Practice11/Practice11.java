package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice11;

public class Practice11 {
    public static void main(String[] args) {
        int[] ia = new int[2];
        ia[0] = new Integer(1); // will be autoboxed to int
        ia[1] = new Integer(2); // autoboxing does work here
        // an array of primitive int:
        System.out.println(ia.getClass().getName());
        Integer[] Ia = new Integer[2];
        Ia[0] = 1; // will be autoboxed to Integer
        Ia[1] = 2; // autoboxing works here
        // an array of Integer:
        System.out.println(Ia.getClass().getName());
        System.out.println(Ia[0] instanceof Integer);
        for (Integer aIa : Ia) System.out.println(aIa.getClass().getName());
        // Integer[] cannot be assigned to int[]:
        // ia = Ia; // error: incompatible types
        Ia[0] = ia[0]; // more autoboxing
        System.out.println(Ia[0].getClass().getName());
    }
}
