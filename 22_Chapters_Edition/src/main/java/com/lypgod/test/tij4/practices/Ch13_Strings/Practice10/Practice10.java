package com.lypgod.test.tij4.practices.Ch13_Strings.Practice10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice10 {
    public static void main(String[] args) {
        String tester = "Java now has regular expressions";
        String[] patters = new String[]{"^Java", "\\Berg.*", "n.w\\s+h(a|i)s", "s?", "s+", "s{4}", "s{1}.", "s{0,3}"};
        System.out.println("Tester: Java now has regular expressions");
        for (String pattern : patters) {
            Matcher matcher = Pattern.compile(pattern).matcher(tester);
            System.out.print("Pattern: \"" + pattern + "\" - ");
            if (!matcher.find()) {
                System.out.println("no match!");
            } else {
                matcher.reset();
                while (matcher.find()) {
                    System.out.print(" | Match \"" + matcher.group() + "\" at position " +
                            matcher.start() + ((matcher.end() - matcher.start() < 2) ? "" : ("-" + (matcher.end() - 1))));
                }
                System.out.println();
            }
        }
    }
}
