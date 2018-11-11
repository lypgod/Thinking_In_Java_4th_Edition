package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice21;

interface Interface21 {
    void printInterface();

    class Nested {
        static void printNested(Interface21 interface21) {
            interface21.printInterface();
        }
    }
}

public class Practice21 implements Interface21 {

    @Override
    public void printInterface() {
        System.out.println("Interface21");
    }

    public static void main(String[] args) {
        Nested.printNested(new Practice21());
    }
}
