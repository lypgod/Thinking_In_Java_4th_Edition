package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Nontask {
    static void rest() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        } finally {
            System.out.println("Good Bye");
        }
    }
}

class Worker implements Runnable {
    public void run() {
        Nontask.rest();
    }
}

public class Practice18 {
    public static void main(String[] args) {
        // 3 ways to do it:
        // use Thread:
        Thread t = new Thread(new Worker());
        t.start();
        t.interrupt();
        // use Executor execute:
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new Worker());
        exec.shutdownNow();
        // use Executor submit:
        ExecutorService exec2 = Executors.newSingleThreadExecutor();
        Future<?> f = exec2.submit(new Worker());
        try {
            TimeUnit.MILLISECONDS.sleep(100); // start task
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted in main()");
        }
        f.cancel(true);
        exec2.shutdown();
    }
}
