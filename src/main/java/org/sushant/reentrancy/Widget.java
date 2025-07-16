package org.sushant.reentrancy;

public class Widget {
    public synchronized void doSomething() {
        System.out.println("From Widget");
    }
}
