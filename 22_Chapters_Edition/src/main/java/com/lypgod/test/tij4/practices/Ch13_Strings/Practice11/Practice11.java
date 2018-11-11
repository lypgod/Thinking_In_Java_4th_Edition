package com.lypgod.test.tij4.practices.Ch13_Strings.Practice11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice11 {
    public static void main(String[] args) {
        String tester = "Arline ate eight apples and one orange while Anita hadn't any";
        Matcher matcher = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b").matcher(tester);
        if (!matcher.find()) {
            System.out.println("no match!");
        } else {
            matcher.reset();
            while (matcher.find()) {
                System.out.println("Match \"" + matcher.group() + "\" at position " + matcher.start() +
                        ((matcher.end() - matcher.start() < 2) ? "" :  ("-" + (matcher.end() - 1))));
            }
        }
    }
}
