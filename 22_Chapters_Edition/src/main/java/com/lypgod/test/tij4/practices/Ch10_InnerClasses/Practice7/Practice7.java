package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice7;

/**
 * Created by liuyp on 16-10-11.
 */
public class Practice7 {
    private int i = 7;
    private void aMethod() {
        System.out.println("Outer method.");
    }

    class Inner {
        void changeI() {
            i = 9;
            aMethod();
        }
    }

    void test() {
        Inner inner = new Inner();
        inner.changeI();
    }

    public static void main(String[] args) {
        Practice7 practice7 = new Practice7();
//        practice7.new Inner().changeI();
        practice7.test();
        System.out.println(practice7.i);
    }
}
