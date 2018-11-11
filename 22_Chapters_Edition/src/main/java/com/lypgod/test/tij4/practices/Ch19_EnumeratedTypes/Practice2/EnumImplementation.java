package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice2;

import java.util.Random;

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random();

    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            System.out.print(CartoonCharacter.next());
            System.out.print((i < 9) ? ", " : "");
        }
    }
}
