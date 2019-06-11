package com.happyghost.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author HappyGhost
 * @create 2019-06-11 22:45
 **/
public class IOClient {
    public static void main(String[] args) {
        new Thread(() ->{
            try {
                Socket socket = new Socket("127.0.0.1",8000);
                while (true) {
                    socket.getOutputStream().write((new Date() + ":hello world").getBytes());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
