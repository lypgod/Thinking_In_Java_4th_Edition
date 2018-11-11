package com.lypgod.test.tij4.practices.Ch15_Generics.Practice8;

import java.util.Iterator;
import java.util.Random;

public class StoryCharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
    @Override
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class StoryCharacterIterator implements Iterator<StoryCharacter> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public StoryCharacter next() {
            count--;
            return StoryCharacterGenerator.this.next();
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<StoryCharacter> iterator() {
        return new StoryCharacterIterator();
    }

    private Class[] types = {GoodGuy.class, BadGuy.class};
    private static Random rand = new Random(47);
    private int size = 0;

    public StoryCharacterGenerator() {
    }

    public StoryCharacterGenerator(int i) {
        size = i;
    }

    public static void main(String[] args) {
        StoryCharacterGenerator gen = new StoryCharacterGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for (StoryCharacter c : new StoryCharacterGenerator(5))
            System.out.println(c);
    }
}
