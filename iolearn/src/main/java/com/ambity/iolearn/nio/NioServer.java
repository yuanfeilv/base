package com.ambity.iolearn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(9000));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//        selector.select();
        while (true){
            selector.select();
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key = it.next();
                //删除本次已处理的key，防止下次select重复处理
                it.remove();
                handle(key);
            }
        }
    }
    private static void handle(SelectionKey key) throws IOException {
        if (key.isAcceptable()){
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = channel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(key.selector(),SelectionKey.OP_READ);
        }else if (key.isReadable()){
//            System.out.println("有客户端数据可读事件发生了。。");
//            SocketChannel sc = (SocketChannel) key.channel();
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            //NIO非阻塞体现:首先read方法不会阻塞，其次这种事件响应模型，当调用到read方法时肯定是发生了客户端发送数据的事件
//            int len = sc.read(buffer);
//            if (len != -1) {
//                System.out.println("读取到客户端发送的数据：" + new String(buffer.array(), 0, len));
//            }
//            ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
//            sc.write(bufferToWrite);
//            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            if (socketChannel.read(buffer)!=-1){
                System.out.println(new String(buffer.array()));
            }
            ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
            socketChannel.write(bufferToWrite);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }else if (key.isWritable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            System.out.println("write事件");
            // NIO事件触发是水平触发
            // 使用Java的NIO编程的时候，在没有数据可以往外写的时候要取消写事件，
            // 在有数据往外写的时候再注册写事件
            key.interestOps(SelectionKey.OP_READ);
            //sc.close();
        }
    }
}
