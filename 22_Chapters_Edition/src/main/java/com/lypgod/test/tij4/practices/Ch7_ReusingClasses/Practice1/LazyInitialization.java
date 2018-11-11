package com.lypgod.test.tij4.practices.Ch7_ReusingClasses.Practice1;

/**
 * Created by liuyp on 16-10-8.
 */
class Lazy {
    Lazy() {
        System.out.println("Lazy Init.");
    }
}
public class LazyInitialization {
    private Lazy lazy;

    private void print() {
        System.out.println("Start print.");
        if (lazy == null) {
            lazy = new Lazy();
        }
        System.out.println("End print.");
    }

    public static void main(String[] args) {
        LazyInitialization lazyInitialization = new LazyInitialization();
        lazyInitialization.print();
        lazyInitialization.print();
    }
}
