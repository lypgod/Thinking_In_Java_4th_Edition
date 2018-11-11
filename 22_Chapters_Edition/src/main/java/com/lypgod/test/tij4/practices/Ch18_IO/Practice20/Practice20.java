package com.lypgod.test.tij4.practices.Ch18_IO.Practice20;

import com.lypgod.test.tij4.practices.Ch18_IO.Directory;

import java.io.File;
import java.io.IOException;

import static com.lypgod.test.tij4.practices.Ch18_IO.Practice19.BinaryFile.read;

public class Practice20 {
    public static void main(String[] args) throws IOException {
        for(File file : Directory.walk(".", ".*\\.class").files) {
            byte[] ba = read(file);
            for(int i = 0; i < 4; i++)
                System.out.print(Integer.toHexString(ba[i] & 0xff).toUpperCase());
            System.out.println();
        }
    }
}
