package com.lypgod.test.tij4.practices.Ch18_IO.Practice4;

import com.lypgod.test.tij4.practices.Ch18_IO.Directory;

import java.io.File;

public class Practice4 {
    public static void main(String[] args) {
        long total = 0;
        for (File file : args.length == 0 ? Directory.walk(".").files : Directory.walk(".", args[0]).files) {
            total += file.length();
        }
        System.out.println(total);
    }
}
