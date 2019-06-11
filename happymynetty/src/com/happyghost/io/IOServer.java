package com.happyghost.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HappyGhost
 * @create 2019-06-11 22:35
 **/
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        // 1.接受新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // 1阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // 2.每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() ->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 3.按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
