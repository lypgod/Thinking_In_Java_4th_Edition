package com.lypgod.test.tij4.practices.Ch21_Concurrency.Practice24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Item {
    private final int itemNum;

    Item(int itemNum) {
        this.itemNum = itemNum;
    }

    public String toString() {
        return "Item " + itemNum;
    }
}

class Producer implements Runnable {
    private int count = 0;
    private Market market;

    Producer(Market m) {
        market = m;
    }

    protected int getCount() {
        return count;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                while (count < 100) {
                    Item item = new Item(++count);
                    if (market.storage.offer(item)) {
                        System.out.println("Produced " + item);
                        // Notify consumer that Item available:
                        synchronized (market.consumer) {
                            market.consumer.notifyAll();
                        }
                    }
                    // Storage holds only 10 Items:
                    synchronized (this) {
                        while (!(market.storage.size() < 10)) {
                            wait();
                        }
                    }
                }
                // Stop production after 100 Items:
                System.out.println("Produced " + count + " Items" + "\nStopping production");
                market.exec.shutdownNow();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
                System.out.println("Produced " + count + " Items");
            }
        }
    }
}

class Consumer implements Runnable {
    private int consumed = 0;
    private Market market;
    private List<Item> cart = new ArrayList<>();

    Consumer(Market m) {
        market = m;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Cannot consume more Items than produced:
                synchronized (this) {
                    while (!(cart.size() < market.producer.getCount())) {
                        wait();
                    }
                }
                // Move Item from storage to cart:
                if (cart.add(market.storage.poll())) {
                    System.out.println("Consuming Item " + ++consumed);
                    // Notify producer - ready for more:
                    synchronized (market.producer) {
                        market.producer.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
            System.out.println("Consumed " + consumed + " Items");
        }
    }
}

public class Market {
    ExecutorService exec = Executors.newCachedThreadPool();
    Queue<Item> storage = new LinkedList<>();
    final Producer producer = new Producer(this);
    final Consumer consumer = new Consumer(this);

    private Market() {
        exec.execute(producer);
        exec.execute(consumer);
    }

    public static void main(String[] args) {
        new Market();
    }
}
