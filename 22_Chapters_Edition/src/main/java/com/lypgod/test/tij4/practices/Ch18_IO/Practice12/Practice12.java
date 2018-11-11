package com.lypgod.test.tij4.practices.Ch18_IO.Practice12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Practice12 {
    public static String readAndReverse(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder(); // For output String
        String[] temp = filename.split("\\.");
        String file = temp[0] + "Reversed." + temp[1];
        PrintWriter out = new PrintWriter(file); // Auto buffered
        int lineCount = 1;
        while ((s = in.readLine()) != null)
            // Add numbered lines to LinkedList
            list.add(lineCount++ + " " + s);
        while (list.peekLast() != null) { // While there is a last line
            String t = list.pollLast(); // Removes line
            out.println(t);
            sb.append(t).append("\n");
        }
        in.close();
        out.close(); // Flush buffer and close
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: enter file name");
            System.exit(1);
        }
        System.out.println(readAndReverse(args[0]));
    }
}
