package com.lypgod.test.tij4.practices.Ch13_Strings.Practice12;//: strings/Groups.java

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.*;

public class Groups {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").matcher(POEM);
        Set<String> result = new LinkedHashSet<>();
        while (m.find()) {
            result.add(m.group());
        }
        System.out.println("Number: " + result.size());
        System.out.println(result);
    }
}
