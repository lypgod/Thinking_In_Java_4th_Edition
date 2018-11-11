package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice8;

import com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice1.LiftOff;

/**
 * Created by liuyp on 16-9-28.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        try { // increase number of threads to see effect
            for(int i = 0; i < 250; i++) {
                Thread t = new Thread(new LiftOff());
                t.setDaemon(true);
                t.start();
            }
            System.out.println("Waiting for LiftOff");

        } finally {
            System.out.println("Finally out of main");
        }
    }
}
