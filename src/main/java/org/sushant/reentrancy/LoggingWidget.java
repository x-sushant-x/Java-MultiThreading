package org.sushant.reentrancy;

public class LoggingWidget extends Widget{
    public synchronized void doSomething() {
        System.out.println("From Logging Widget");

        super.doSomething();
    }
}
