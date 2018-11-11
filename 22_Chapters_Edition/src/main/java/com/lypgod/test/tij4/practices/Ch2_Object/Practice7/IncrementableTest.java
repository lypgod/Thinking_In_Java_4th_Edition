package com.lypgod.test.tij4.practices.Ch2_Object.Practice7;

class Incrementable {
    static int i = 47;
    static void increment() { i++; }
}

public class IncrementableTest {
    public static void main(String[] args) {
        Incrementable incrementable = new Incrementable();
        System.out.println(incrementable.i);
        incrementable.increment();
        System.out.println(incrementable.i);
        Incrementable.increment();
        System.out.println(incrementable.i);
    }
}
