package com.lypgod.test.tij4.practices.Ch15_Generics.Practice25;

interface InterfaceA {

}

interface InterfaceB {

}

class InterfaceABImpl implements InterfaceA, InterfaceB {
    @Override
    public String toString() {
        return "InterfaceABImpl";
    }
}

public class Practice25 {
    <T extends InterfaceA> void getA(T t) {
        System.out.println("A - " + t);
    }

    <T extends InterfaceB> void getB(T t) {
        System.out.println("B - " + t);
    }

    public static void main(String[] args) {
        InterfaceABImpl interfaceAB = new InterfaceABImpl();
        Practice25 practice25 = new Practice25();
        practice25.getA(interfaceAB);
        practice25.getB(interfaceAB);
    }
}
