package com.lypgod.test.tij4.practices.Ch17_Containers.Practice4;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Practice4 {
    static Collection<String> getArrayListCollection(String input) {
        return Arrays.asList(input.split(" "));
    }
    static Collection<String> getTreeSetCollection(String input) {
        Collection<String> result = new TreeSet<>();
        for (String s:input.split(" ")) {
            result.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "ANGOLA ALGERIA AZERBAIJAN ARMENIA AFGHANISTAN ANDORRA AUSTRIA ANTIGUA AND BARBUDA AUSTRALIA ARGENTINA ALBANIA ARGENTINA";
        System.out.println(getArrayListCollection(input));
        System.out.println(getTreeSetCollection(input));
    }
}
