package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice18;

import java.util.Arrays;

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}

public class Practice18 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres1 = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        System.out.println(Arrays.toString(berylliumSpheres1));
        BerylliumSphere[] berylliumSpheres2 = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        System.out.println(Arrays.toString(berylliumSpheres2));
        BerylliumSphere[] berylliumSpheres3 = new BerylliumSphere[3];
        System.arraycopy(berylliumSpheres2, 0, berylliumSpheres3, 0, 3);
        System.out.println(Arrays.toString(berylliumSpheres3));
    }
}
