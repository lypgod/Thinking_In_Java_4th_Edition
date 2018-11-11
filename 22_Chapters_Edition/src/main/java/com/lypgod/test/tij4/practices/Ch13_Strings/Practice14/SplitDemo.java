package com.lypgod.test.tij4.practices.Ch13_Strings.Practice14;//: strings/SplitDemo.java

import java.util.regex.*;
import java.util.*;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
    }
}