package org.sushant.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int N_THREADS = 2;
    private static final Executor executor = Executors.newFixedThreadPool(N_THREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);

        while (true) {
            final Socket conn = socket.accept();

            Runnable task = () -> {
                System.out.println("Handling: " + conn.getInetAddress());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            executor.execute(task);
        }
    }
}
