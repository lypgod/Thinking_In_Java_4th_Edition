package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice14;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Practice14 {

    public static void main(String[] args) {
        int time;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            time = (random.nextInt(10) + 1) * 1000;
            final int finalTime = time;
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println("Time = " + finalTime);
                        }
                    }, time
            );
        }
    }
}
