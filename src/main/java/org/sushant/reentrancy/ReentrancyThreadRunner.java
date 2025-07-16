package org.sushant.reentrancy;

import java.util.List;
import java.util.stream.IntStream;

public class ReentrancyThreadRunner implements Runnable {
    LoggingWidget loggingWidget;

    public ReentrancyThreadRunner(LoggingWidget loggingWidget) {
        this.loggingWidget = loggingWidget;
    }


    public void runMultiThreaded() {
        ReentrancyThreadRunner threadRunner = new ReentrancyThreadRunner(loggingWidget);

        List<Thread> threads = IntStream.range(0, 1000)
                .mapToObj(_ -> new Thread(threadRunner))
                .toList();

        threads.forEach(Thread::start);
    }

    @Override
    public void run() {
        loggingWidget.doSomething();
    }
}
