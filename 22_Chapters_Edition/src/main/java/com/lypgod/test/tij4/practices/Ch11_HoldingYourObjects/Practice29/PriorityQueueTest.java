package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice29;

import java.util.PriorityQueue;

/**
 * Created by liuyp on 16-10-13.
 */
class SimpleObject {

}
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<SimpleObject> d = new PriorityQueue<>();
        for (int i = 0; i < 10; i++)
            d.offer(new SimpleObject());
        while (d.peek() != null)
            System.out.print(d.poll() + " ");
    }
}
