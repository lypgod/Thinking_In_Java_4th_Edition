package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice9;

class This {
    This() {
        System.out.println("This()");
    }
    This(String s) {
        this();
        System.out.println(s);
    }
}

public class ThisTest {
    public static void main(String[] args) {
        This aThis = new This("sssss");
    }
}
