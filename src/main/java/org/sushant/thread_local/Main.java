package org.sushant.thread_local;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            UserContext.set(Thread.currentThread().getName());
            System.out.println("User in thread: " + UserContext.get());
            UserContext.clear();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
