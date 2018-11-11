package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice4;

public class ConstructionTest {
    ConstructionTest(String s) {
        System.out.println("Constructed. " + s);
    }

    public static void main(String[] args) {
        ConstructionTest constructionTest = new ConstructionTest("args");
    }
}
