package org.sushant.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifeCycleWebServer {
    private final ExecutorService exec = Executors.newFixedThreadPool(2);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);

        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(() -> {
                    handleRequest(conn);
                });
            } catch (RejectedExecutionException e) {

            }
        }
    }

    public void stop() { exec.shutdown(); }

    private void handleRequest(Socket conn) {}
}
