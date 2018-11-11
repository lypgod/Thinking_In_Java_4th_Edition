package com.lypgod.test.tij4.practices.Ch3_Operators.Practice11;

public class RightShiftTest {
    public static void main(String [] args) {
        int h = 0x10000000;
        System.out.println(Integer.toBinaryString(h));
        for(int i = 0; i < 28; i++) {
            h >>>= 1;
            System.out.println(Integer.toBinaryString(h));
        }
    }
}
