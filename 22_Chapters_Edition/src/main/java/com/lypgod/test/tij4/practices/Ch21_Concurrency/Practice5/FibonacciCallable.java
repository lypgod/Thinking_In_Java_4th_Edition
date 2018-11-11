package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice5;

import com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice2.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liuyp on 16-9-27.
 */
public class FibonacciCallable implements Callable<String> {
    private String result = "";
    private int length;

    public FibonacciCallable(int n) {
        length = n;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            results.add(exec.submit(new FibonacciCallable(10)));
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }

    @Override
    public String call() throws Exception {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < length; i++)
            result += gen.next() + " ";
        return result;
    }
}
