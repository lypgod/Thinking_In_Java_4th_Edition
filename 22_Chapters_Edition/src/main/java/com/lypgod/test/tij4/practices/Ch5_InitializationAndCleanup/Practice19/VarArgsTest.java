package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice19;

public class VarArgsTest {
    static void print(String... args) {
        for(String s:args) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        print("aaa", "bbb", "ccc");
        print(new String[]{"ddd", "eee", "fff"});
    }
}
