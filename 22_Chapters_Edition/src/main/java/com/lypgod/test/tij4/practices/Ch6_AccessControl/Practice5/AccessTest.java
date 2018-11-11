package com.lypgod.test.tij4.practices.Ch6_AccessControl.Practice5;

/**
 * Created by liuyp on 16-10-8.
 */
public class AccessTest {
    public static void main(String[] args) {
        FourWays fw = new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a = 10;
        fw.b = 20;
        fw.c = 30;
        fw.showa();
        fw.showb();
        fw.showc();
        //! fw.showd(); // private access, compiler can't touch
    }
}
