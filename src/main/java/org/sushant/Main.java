package org.sushant;

import org.sushant.reentrancy.LoggingWidget;
import org.sushant.reentrancy.ReentrancyThreadRunner;

public class Main {
    public static void main(String[] args) {

        // Race Condition
        /*
            Initializer initializer = new Initializer(new LazyInitialize());
            initializer.testInitialize();
        */

        // synchronized deadlock
        /*
            ReentrancyThreadRunner reentrancyThreadRunner = new ReentrancyThreadRunner(new LoggingWidget());
            reentrancyThreadRunner.runMultiThreaded();
        */
    }
}