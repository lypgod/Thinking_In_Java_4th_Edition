package com.lypgod.test.tij4.practices.Ch18_IO.Practice13;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class Practice13 {
    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(new FileReader("BasicFileOutput13.java"));
        PrintWriter out = new PrintWriter("");
        String s;
        while ((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(""));
    }
}
