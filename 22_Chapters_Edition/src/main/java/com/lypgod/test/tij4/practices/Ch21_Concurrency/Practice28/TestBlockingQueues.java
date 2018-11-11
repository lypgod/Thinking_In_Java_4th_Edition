package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice28;

import java.util.concurrent.*;
import java.io.*;

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

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run(); // Use this thread
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

class LiftOffAdder implements Runnable {
    private LiftOffRunner runner;

    LiftOffAdder(LiftOffRunner runner) {
        this.runner = runner;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
    }
}

public class TestBlockingQueues {
    private static void getkey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    private static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        LiftOffAdder adder = new LiftOffAdder(runner);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(runner);
        exec.execute(adder);
        getkey("Press 'Enter' (" + msg + ")");
        System.out.println("Finished " + msg + " test");
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Size of 1
                new SynchronousQueue<LiftOff>());
    }
} ///:~
