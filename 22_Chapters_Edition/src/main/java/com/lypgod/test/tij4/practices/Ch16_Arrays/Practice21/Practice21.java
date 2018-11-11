package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice21;

import java.util.Arrays;
import java.util.Comparator;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

class CompBerylliumSphere implements Comparable<CompBerylliumSphere> {
    private static long count;
    protected final long id = count++;

    public int compareTo(CompBerylliumSphere c2) {
        return (this.id < c2.id ? -1 : (this.id == c2.id ? 0 : 1));
    }

    public String toString() {
        return "BerylliumSphere " + id;
    }
}

class CompBerylliumSphereComparator implements Comparator<CompBerylliumSphere> {
    public int compare(CompBerylliumSphere c1, CompBerylliumSphere c2) {
        return (c1.id > c2.id ? -1 : (c1.id == c2.id ? 0 : 1));
    }
}

public class Practice21 {
    public static void main(String[] args) {
        BerylliumSphere[] bsa = new BerylliumSphere[5];
        for (int i = 0; i < bsa.length; i++) {
            bsa[i] = new BerylliumSphere();
        }
        // Arrays.sort(bsa); // runtime ClassCastException
        CompBerylliumSphere[] cbsa = new CompBerylliumSphere[5];
        for (int i = 0; i < cbsa.length; i++) {
            cbsa[i] = new CompBerylliumSphere();
        }
        System.out.println("unsorted:");
        System.out.println(Arrays.toString(cbsa));
        Arrays.sort(cbsa);
        System.out.println("sorted:");
        System.out.println(Arrays.toString(cbsa));
        Arrays.sort(cbsa, new CompBerylliumSphereComparator());
        System.out.println("reverse sorted:");
        System.out.println(Arrays.toString(cbsa));
    }
}
