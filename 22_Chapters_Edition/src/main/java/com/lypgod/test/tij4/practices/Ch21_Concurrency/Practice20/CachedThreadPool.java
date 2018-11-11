package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice20;

import java.util.concurrent.*;

class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using LiftOff:");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Future<?> f = exec.submit(new LiftOff());
            f.cancel(true);
        }
        exec.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        // Using modified LiftOff:
        System.out.println("\nUsing LiftOff20:");
        ExecutorService exec20 = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            Future<?> f = exec20.submit(new LiftOff());
            f.cancel(true);
        }
        exec20.shutdownNow();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        //        ExecutorService exec = Executors.newCachedThreadPool();
        //        for (int i = 0; i < 5; i++) {
        //            exec.execute(new LiftOff());
        //        }
        //        exec.shutdownNow();
    }
} /* Output: (Sample)
#0(9), #0(8), #1(9), #2(9), #3(9), #4(9), #0(7), #1(8), #2(8), #3(8), #4(8), #0(6), #1(7), #2(7), #3(7), #4(7), #0(5), #1(6), #2(6), #3(6), #4(6), #0(4), #1(5), #2(5), #3(5), #4(5), #0(3), #1(4), #2(4), #3(4), #4(4), #0(2), #1(3), #2(3), #3(3), #4(3), #0(1), #1(2), #2(2), #3(2), #4(2), #0(Liftoff!), #1(1), #2(1), #3(1), #4(1), #1(Liftoff!), #2(Liftoff!), #3(Liftoff!), #4(Liftoff!),
*///:~
