package com.lypgod.test.tij4.practices.Ch15_Generics.Practice18;

import java.util.*;

class BigFish {
    private static long counter = 1;
    private final long id = counter++;

    private BigFish() {
    }

    public String toString() {
        return "Big fish " + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class SmallFish {
    private static long counter = 1;
    private final long id = counter++;

    private SmallFish() {
    }

    public String toString() {
        return "Samll fish " + id;
    }

    public static Generator<SmallFish> generator() {
        return new Generator<SmallFish>() {
            @Override
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }
}

public class Fish {
    public static void eats(BigFish bigFish, SmallFish smallFish) {
        System.out.println(bigFish + " eats " + smallFish);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<SmallFish> smallFishQueue = new LinkedList<>();
        Generators.fill(smallFishQueue, SmallFish.generator(), 15);
        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 4);

        for (SmallFish s : smallFishQueue) {
            eats(bigFishList.get(random.nextInt(bigFishList.size())), s);
        }
    }
}
