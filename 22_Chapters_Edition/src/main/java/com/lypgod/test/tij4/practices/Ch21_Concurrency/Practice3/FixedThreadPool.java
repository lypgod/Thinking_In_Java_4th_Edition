package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice3;

import com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuyp on 16-9-27.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i=0; i<20; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
