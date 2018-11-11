package com.lypgod.test.tij4.practices.Ch4_ControllingExecution.Practice7;

public class ReturnTest {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            if (i == 99) return;
        }
    }
}
