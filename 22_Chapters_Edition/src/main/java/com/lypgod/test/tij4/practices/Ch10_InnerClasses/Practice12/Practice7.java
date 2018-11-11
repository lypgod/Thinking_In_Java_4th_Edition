package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice12;

/**
 * Created by liuyp on 16-10-11.
 */
interface Inner {
    void changeI();
}
public class Practice7 {
    private int i = 7;
    private void aMethod() {
        System.out.println("Outer method.");
    }

//    class Inner {
//        void changeI() {
//            i = 9;
//            aMethod();
//        }
//    }

    Inner test() {
        return new Inner() {
            @Override
            public void changeI() {
                i = 9;
                aMethod();
            }
        };
    }

    public static void main(String[] args) {
        Practice7 practice7 = new Practice7();
        practice7.test().changeI();
        System.out.println(practice7.i);
    }
}
