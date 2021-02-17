package com.ambity.iolearn.bio;

import java.io.IOException;
import java.net.Socket;

public class BioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9000);
        socket.getOutputStream().write("nihao".getBytes());
        socket.getOutputStream().flush();
        byte[] bytes = new byte[1024];
        //接收服务端回传的数据
        socket.getInputStream().read(bytes);
        System.out.println("接收到服务端的数据：" + new String(bytes));
        socket.close();
    }
}
