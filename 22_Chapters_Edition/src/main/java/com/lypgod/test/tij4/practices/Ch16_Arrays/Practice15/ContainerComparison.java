package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice15;//: arrays/ContainerComparison.java


import java.util.*;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
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

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        BerylliumSphereGenerator bsg = new BerylliumSphereGenerator();
        Generated.array(spheres, bsg);
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        List<BerylliumSphere> sphereList =
                new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++)
            sphereList.add(bsg.next());
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));
//        BerylliumSphere[] spheres = new BerylliumSphere[10];
//        for (int i = 0; i < 5; i++)
//            spheres[i] = new BerylliumSphere();
//        System.out.println(Arrays.toString(spheres));
//        System.out.println(spheres[4]);
//
//        List<BerylliumSphere> sphereList = new ArrayList<>();
//        for (int i = 0; i < 5; i++)
//            sphereList.add(new BerylliumSphere());
//        System.out.println(sphereList);
//        System.out.println(sphereList.get(4));
//
//        int[] integers = {0, 1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(integers));
//        System.out.println(integers[4]);
//
//        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
//        intList.add(97);
//        System.out.println(intList);
//        System.out.println(intList.get(4));
    }
} /* Output:
[Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, null, null, null, null, null]
Sphere 4
[Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
Sphere 9
[0, 1, 2, 3, 4, 5]
4
[0, 1, 2, 3, 4, 5, 97]
4
*///:~
