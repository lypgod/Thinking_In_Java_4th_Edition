package com.lypgod.test.tij4.practices.Ch18_IO.Practice21;

import java.io.*;

public class Practice21 {
    public static void main(String[] args) throws IOException {
        File file = new File("Ex21.java");
        BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(file));
        System.setIn(inFile);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null)
            System.out.println(s.toUpperCase());
    }
}
