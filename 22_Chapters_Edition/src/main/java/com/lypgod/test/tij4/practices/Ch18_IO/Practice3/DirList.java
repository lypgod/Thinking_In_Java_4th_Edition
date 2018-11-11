package com.lypgod.test.tij4.practices.Ch18_IO.Practice3;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles();
        long total = 0;
        if (files != null) {
            for (File file : files) {
                total += file.length();
            }
        }

        System.out.println(total);
    }
}