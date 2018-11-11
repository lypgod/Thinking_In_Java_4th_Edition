package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice18;

public class Practice18 {
    private static class Inner {
        void print() {
            System.out.println("Inner.");
        }
    }

    private static Inner getInner() {
        return new Inner();
    }
    public static void main(String[] args) {
        getInner().print();
    }
}
