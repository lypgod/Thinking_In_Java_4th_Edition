package com.lypgod.test.tij4.practices.Ch15_Generics.Practice8;

public class StoryCharacter {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
