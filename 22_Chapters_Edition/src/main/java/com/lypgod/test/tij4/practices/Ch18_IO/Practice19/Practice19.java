package com.lypgod.test.tij4.practices.Ch18_IO.Practice19;

import java.io.IOException;
import java.util.*;

public class Practice19 {
    public static void main(String[] args) {
        // File whose Characters are to be counted:
        String fileName = "ByteCounter19.java";
        try {
            // Array of all bytes in file:
            byte[] ba = BinaryFile.read(fileName);
            // Set of unique Bytes in file:
            Set<Byte> byteSet = new TreeSet<>();
            for (Byte b : ba)
                byteSet.add(b); // Autoboxing
            // List of all Bytes in file:
            List<Byte> byteList = new ArrayList<>();
            for (byte b : ba)
                byteList.add(b);
            Map<Byte, Integer> byteMap = new HashMap<>();
            for (Byte b : byteSet) {
                int count = 0;
                for (Byte d : byteList) {
                    if (d.equals(b))
                        count++;
                }
                byteMap.put(b, count);
            }
            System.out.println();
            System.out.println(byteMap);
        } catch (IOException e) {
            System.err.print("Caught " + e);
        }
    }
}
