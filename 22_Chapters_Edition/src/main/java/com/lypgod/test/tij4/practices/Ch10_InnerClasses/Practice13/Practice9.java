package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice13;

/**
 * Created by liuyp on 16-10-12.
 */
interface AnInterface {
    void print();
}

public class Practice9 {
    AnInterface getAnInterface() {
        return new AnInterface() {
            @Override
            public void print() {
                System.out.println("This is an anonynous inner class.");
            }
        };
    }

    public static void main(String[] args) {
        AnInterface anInterface =  new Practice9().getAnInterface();
        anInterface.print();
    }
}
