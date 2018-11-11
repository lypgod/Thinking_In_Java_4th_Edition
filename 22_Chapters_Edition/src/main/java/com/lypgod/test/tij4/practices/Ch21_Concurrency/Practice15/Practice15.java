package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice15;

class SyncTest1 { // all methods synchronized on this
    public void f1() {
        synchronized (this) {
            for (int i = 0; i < 500; i++) {
                System.out.println("f1()");
                Thread.yield();
            }
        }
    }

    void g1() {
        synchronized (this) {
            for (int i = 0; i < 500; i++) {
                System.out.println("g1()");
                Thread.yield();
            }
        }
    }

    void h1() {
        synchronized (this) {
            for (int i = 0; i < 500; i++) {
                System.out.println("h1()");
                Thread.yield();
            }
        }
    }
}

class SyncTest2 { // methods synchronized on different objects
    private final Object syncObject1 = new Object();
    private final Object syncObject2 = new Object();
    private final Object syncObject3 = new Object();

    public void f2() {
        synchronized (syncObject1) {
            for (int i = 0; i < 500; i++) {
                System.out.println("f2()");
                Thread.yield();
            }
        }
    }

    void g2() {
        synchronized (syncObject2) {
            for (int i = 0; i < 500; i++) {
                System.out.println("g2()");
                Thread.yield();
            }
        }
    }

    void h2() {
        synchronized (syncObject3) {
            for (int i = 0; i < 500; i++) {
                System.out.println("h2()");
                Thread.yield();
            }
        }
    }
}

public class Practice15 {
    public static void main(String[] args) {
        final SyncTest1 st1 = new SyncTest1();
        final SyncTest2 st2 = new SyncTest2();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
    }

}
