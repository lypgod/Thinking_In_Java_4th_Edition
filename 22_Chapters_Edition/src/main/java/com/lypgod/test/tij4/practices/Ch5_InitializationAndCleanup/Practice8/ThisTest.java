package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice8;

class This {
    void f1() {
        f2();
        this.f2();
    }
    void f2() {
        System.out.println("S2");
    }
}

public class ThisTest {
    public static void main(String[] args) {
        This aThis = new This();
        aThis.f1();
    }
}
