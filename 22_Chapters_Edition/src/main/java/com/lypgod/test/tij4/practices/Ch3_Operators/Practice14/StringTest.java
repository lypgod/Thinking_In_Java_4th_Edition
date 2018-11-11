package com.lypgod.test.tij4.practices.Ch3_Operators.Practice14;

public class StringTest {
    static boolean equalTest1(String a, String b) {
        return a == b;
    }
    static boolean equalTest2(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        System.out.println(equalTest1("aa", "aa"));
        System.out.println(equalTest2("aa", "aa"));
    }
}
