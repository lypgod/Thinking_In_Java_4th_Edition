package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice2;

public class StringInitTest {
    String s1 = "String1";
    String s2;
    StringInitTest () {
        s2 = "String2";
    }
    public static void main(String[] args) {
        StringInitTest stringInitTest = new StringInitTest();
        System.out.println(stringInitTest.s1);
        System.out.println(stringInitTest.s2);
    }
}
