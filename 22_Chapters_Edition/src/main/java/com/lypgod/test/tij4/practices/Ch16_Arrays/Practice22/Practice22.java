package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

interface Generator<T> {
    T next();
}

class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
}

class Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
}

public class Practice22 {
    private static Random r = new Random();

    public static void main(String[] args) {
        int[] ia = ConvertTo.primitive(Generated.array(new Integer[20], (Generator<Integer>) new RandomGenerator.Integer(10)));
        System.out.println(Arrays.toString(ia));
        for (int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if (index < 0) System.out.println(i + " not found");
            else
                System.out.println("Index: " + index + ", " + i);
        }
        System.out.println("sort");
        Arrays.sort(ia);
        System.out.println(Arrays.toString(ia));
        for (int i = 0; i < 10; i++) {
            int index = Arrays.binarySearch(ia, i);
            if (index < 0) System.out.println(i + " not found");
            else
                System.out.println("Index: " + index + ", " + i);
        }
    }
}
