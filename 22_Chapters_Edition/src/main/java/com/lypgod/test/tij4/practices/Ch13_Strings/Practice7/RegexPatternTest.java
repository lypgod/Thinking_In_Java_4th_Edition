package com.lypgod.test.tij4.practices.Ch13_Strings.Practice7;

public class RegexPatternTest {
    // starts with any capital A through Z
    // then zero or more of any char except endline
    // ends with .
    private static String regPattern = "^[A-Z].*[\\.]$";

    public static void main(String[] args) {
        String s1 = "Once upon a time.";
        String s2 = "abcd.";
        String s3 = "Abcd?";
        String s4 = "An easy way out.";
        String s5 = "Zorro.";
        String s6 = "X.";
        System.out.println(s1.matches(regPattern));
        System.out.println(s2.matches(regPattern));
        System.out.println(s3.matches(regPattern));
        System.out.println(s4.matches(regPattern));
        System.out.println(s5.matches(regPattern));
        System.out.println(s6.matches(regPattern));
    }
}
