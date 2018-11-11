package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice16;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class RandomChars {
    private static Random rand = new Random();

    public char next() {
        return (char) rand.nextInt(128);
    }

    public static void main(String[] args) {
        RandomChars rc = new RandomChars();
        for (int i = 0; i < 10; i++)
            System.out.print(rc.next() + " ");
    }
}

public class AdaptedRandomChars extends RandomChars implements Readable {
    private int count;

    public AdaptedRandomChars(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) {
        if (count-- == 0) return -1;
        String result = Character.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomChars(10));
        while (s.hasNext())
            System.out.println(s.next() + " ");
    }
}
