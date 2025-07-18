package org.sushant.monitor_pattern;

import java.util.Random;

public class BoundedBuffer {
    private final int[] buffer;
    private int count, putPTR, getPTR;

    BoundedBuffer(int size) {
        buffer = new int[size];
    }

    public synchronized void put() throws InterruptedException {
        while(count == buffer.length) {
            System.out.println(Thread.currentThread().getName() + " waiting to put.");
            wait();
        }

        buffer[putPTR] = new Random().nextInt();
        putPTR = (putPTR + 1) % buffer.length;
        count++;

        System.out.println(Thread.currentThread().getName() + " put succeed.");

        notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while (count == 0) {
            System.out.println(Thread.currentThread().getName() + " waiting to get.");
            wait();
        }

        getPTR = (getPTR + 1) % buffer.length;
        count--;

        System.out.println(Thread.currentThread().getName() + " get succeed.");

        notifyAll();
    }

    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer(2);

        Thread producer = new Thread(() -> {
            try {
                while (true) {
                    boundedBuffer.put();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    boundedBuffer.get();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
