package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice9;

/**
 * Created by liuyp on 16-10-12.
 */
interface AnInterface {
    void print();
}

public class Practice9 {
    AnInterface getAnInterface() {
        class IsAnInterface implements AnInterface {
            public void print() {
                System.out.println("IsAnInterface");
            }
        }
        return new IsAnInterface();
    }

    public static void main(String[] args) {
        AnInterface anInterface =  new Practice9().getAnInterface();
        anInterface.print();
    }
}
