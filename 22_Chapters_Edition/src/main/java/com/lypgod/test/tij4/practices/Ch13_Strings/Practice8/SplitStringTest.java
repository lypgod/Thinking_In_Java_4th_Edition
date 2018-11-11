package com.lypgod.test.tij4.practices.Ch13_Strings.Practice8;

import java.util.Arrays;

public class SplitStringTest {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split("the|you");
    }
}
