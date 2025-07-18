package org.sushant.task_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);

        while (true) {
            final Socket conn = socket.accept();

            Runnable task = () -> System.out.println("Connection From: " + conn.getInetAddress());

            new Thread(task).start();
        }
    }
}
