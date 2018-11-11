package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice10;

/**
 * Created by liuyp on 16-10-12.
 */
interface AnInterface {
    void print();
}

public class Practice9 {
    AnInterface getAnInterface(boolean b) {
        if (b) {
            class IsAnInterface implements AnInterface {
                public void print() {
                    System.out.println("IsAnInterface");
                }
            }
            return new IsAnInterface();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        new Practice9().getAnInterface(true).print();
        new Practice9().getAnInterface(false).print();
    }
}
