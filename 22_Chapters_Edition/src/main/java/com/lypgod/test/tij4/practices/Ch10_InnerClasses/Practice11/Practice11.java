package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice11;

/**
 * Created by liuyp on 16-10-12.
 */
interface AnInterface {
    void Print();
}

class Outer {
    private class Inner implements AnInterface {
        @Override
        public void Print() {
            System.out.println("Inner");
        }
    }

    AnInterface getInner() {
        return new Inner();
    }
}

public class Practice11 {

    public static void main(String[] args) {
        new Outer().getInner().Print();
    }
}
