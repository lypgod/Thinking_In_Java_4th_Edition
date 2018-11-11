package com.lypgod.test.tij4.practices.Ch19_EnumeratedTypes.Practice5;

import java.util.Arrays;
import java.util.Random;

public enum VowelsAndConsonants {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('w', 'y'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z');
    private Character[] letters;

    VowelsAndConsonants(Character... letters) {
        this.letters = letters;
    }

    public static VowelsAndConsonants LetterType(Character c) {
        if (Arrays.asList(VOWEL.letters).contains(c))
            return VOWEL;
        if (Arrays.asList(SOMETIMES_A_VOWEL.letters).contains(c))
            return SOMETIMES_A_VOWEL;
        return CONSONANT;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            System.out.print((char) c + ", " + c + ": ");
            System.out.println(LetterType((char) c));
        }
    }
}
