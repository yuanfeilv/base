package com.ambity.iolearn.bio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            Socket socket = serverSocket.accept();
            Thread thread = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    handle(socket);
                }
            });
            thread.start();
        }

    }
    public static void handle(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        if (read!=-1){
            System.out.println(new String(bytes));
        }
        socket.getOutputStream().write("hello".getBytes());
        socket.getOutputStream().flush();
    }
}
