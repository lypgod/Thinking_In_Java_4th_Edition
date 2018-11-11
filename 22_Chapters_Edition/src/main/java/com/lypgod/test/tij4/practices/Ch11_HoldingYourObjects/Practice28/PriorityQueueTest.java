package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice28;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by liuyp on 16-10-13.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Random rand = new Random();
        PriorityQueue<Double> d = new PriorityQueue<>();
        for (int i = 0; i < 10; i++)
            d.offer(rand.nextDouble() * i);
        while (d.peek() != null)
            System.out.print(d.poll() + " ");
    }
}
