package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice20;

interface Interface20 {
    void print();

    class Nested {
        Nested() {
            System.out.println("Nested.");
        }
    }
}

class Interface20Impl implements Interface20 {

    @Override
    public void print() {
        System.out.println("Interface20.");
    }
}

public class Practice20 {
    public static void main(String[] args) {
        Interface20 interface20 = new Interface20Impl();
        interface20.print();
        Interface20.Nested nested = new Interface20.Nested();
    }
}
