package com.lypgod.test.tij4.practices.Ch13_Strings.Practice9;

import java.util.Arrays;

public class ReplaceStringTest {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        System.out.println(knights.replaceAll("a|A|e|E|i|I|o|O|u|U", "_"));
        System.out.println(knights.replaceAll("[aAeEiIoOuU]", "_"));
    }
}
