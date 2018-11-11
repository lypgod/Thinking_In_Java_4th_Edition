package com.lypgod.test.tij4.practices.Ch18_IO.Practice17;

import java.io.IOException;
import java.util.*;

public class Practice17 {
    public static void main(String[] args) throws IOException {
        String fileName = "pom.xml";
        char[] ca = BufferedInputFile.read(fileName).toCharArray();
        Set<Character> charSet = new TreeSet<>();
        for (char c : ca)
            charSet.add(c);
        List<Character> charList = new ArrayList<>();
        for (char c : ca)
            charList.add(c);
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character c : charSet) {
            int count = 0;
            for (Character d : charList) {
                if (d.equals(c))
                    count++;
            }
            charMap.put(c, count);
        }
        System.out.println();
        System.out.println(charMap);

    }
}
