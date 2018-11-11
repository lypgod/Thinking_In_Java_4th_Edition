package com.lypgod.test.tij4.practices.Ch17_Containers.Practice9;

import java.util.TreeSet;

public class Practice9 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        RandomGenerator.String rgs = new RandomGenerator.String(5);
        for (int i = 0; i < 20; i++) {
            ts.add(rgs.next());
        }
        System.out.println(ts);
    }
}
