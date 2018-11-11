package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice14;

import java.util.Arrays;

public class Practice14 {
    public static void main(String[] args) {
        boolean[] booleens = new boolean[3];
        short[] shorts = new short[3];
        char[] chars = new char[3];
        int[] ints = new int[3];
        byte[] bytes = new byte[3];
        long[] longs = new long[3];
        float[] floats = new float[3];
        double[] doubles = new double[3];

        CountingGenerator.Boolean cBoolean = new CountingGenerator.Boolean();
        CountingGenerator.Short cShort = new CountingGenerator.Short();
        CountingGenerator.Character cCharactor = new CountingGenerator.Character();
        CountingGenerator.Integer cInteger = new CountingGenerator.Integer();
        CountingGenerator.Byte cByte = new CountingGenerator.Byte();
        CountingGenerator.Long cLong = new CountingGenerator.Long();
        CountingGenerator.Float cFloat = new CountingGenerator.Float();
        CountingGenerator.Double cDouble = new CountingGenerator.Double();

        for (int i = 0; i < 3; i++) {
            booleens[i] = cBoolean.next();
            shorts[i] = cShort.next();
            chars[i] = cCharactor.next();
            ints[i] = cInteger.next();
            bytes[i] = cByte.next();
            longs[i] = cLong.next();
            floats[i] = cLong.next();
            doubles[i] = cDouble.next();
        }

        System.out.println(Arrays.toString(booleens));
        System.out.println(Arrays.toString(shorts));
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(floats));
        System.out.println(Arrays.toString(doubles));
    }
}
