package com.lypgod.test.tij4.practices.Ch17_Containers.Practice26;//: containers/CountedString.java
// Creating a good hashCode().

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char c;

    public CountedString(String str, char ch) {
        s = str;
        c = ch;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString:
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'c');
            map.put(cs[i], i); // Autobox int -> Integer
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }

    public String toString() {
        return "String: " + s + " id: " + id + ", c: " + c + " hashCode(): " + hashCode();
    }

    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id;
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + c;
        return result;
    }

    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString) o).s) && id == ((CountedString) o).id && c == ((CountedString) o).c;
    }
}