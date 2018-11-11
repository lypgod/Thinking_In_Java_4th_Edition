package com.lypgod.test.tij4.practices.Ch15_Generics.Practice6;//: generics/RandomList.java

import java.util.*;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<Integer> integerRandomList = new RandomList<>();
        for (int i = 10; i<20; i++)
            integerRandomList.add(i);
        for (int i = 0; i < 11; i++)
            System.out.print(integerRandomList.select() + " ");

        System.out.println();

        RandomList<Character> characterRandomList = new RandomList<>();
        for (char c = 'a'; c <= 'z'; c++)
            characterRandomList.add(c);
        for (int i = 0; i < 26; i++)
            System.out.print(characterRandomList.select() + " ");
    }
}