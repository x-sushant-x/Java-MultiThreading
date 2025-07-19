package org.sushant.task_execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);

        Callable<String> task = () -> {
            return "Hello";
        };

        Future<String> future = exec.submit(task);

        System.out.println("Task Submitted");

        String res = future.get();
        System.out.println("Result: " + res);

        exec.shutdown();
    }
}
