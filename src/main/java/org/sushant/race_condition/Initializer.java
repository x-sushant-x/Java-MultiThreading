package org.sushant.race_condition;

import java.util.List;
import java.util.stream.IntStream;

public class Initializer implements Runnable {
    public final LazyInitialize lazyInitialize;

    public Initializer(LazyInitialize lazyInitialize) {
        this.lazyInitialize = lazyInitialize;
    }

    @Override
    public void run() {
        lazyInitialize.initializeObject();
    }

    public void testInitialize() {
        Initializer initializer = new Initializer(lazyInitialize);

        List<Thread> threads = IntStream.range(0, 1000)
                .mapToObj(_ -> new Thread(initializer))
                .toList();

        threads.forEach(Thread::start);

        lazyInitialize.getTotalObjectsCreated();
    }
}