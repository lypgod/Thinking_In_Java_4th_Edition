package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice10;

class Finalize {
    protected void finalize() {
        System.out.println("Fianlize.");
    }
}

public class FinalizeTest {

    public static void main(String[] args) {
        Finalize finalize = new Finalize();
        finalize = null;
        System.gc();
    }
}
