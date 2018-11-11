package com.lypgod.test.tij4.practices.Ch2_Object.Practice1;


import org.junit.Test;

/**
 * Created by lypgod on 2016/9/26.
 */
public class Practice1 {
    private boolean bo;
    private char c;
    private byte by;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;

    private void printInitValues() {
        System.out.println("boolean: " + bo);
        System.out.println("char: " + Integer.toHexString((int)c));
        System.out.println("byte: " + by);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
    }

    @Test
    public void testPrintInitValues() {
        printInitValues();
    }
}
