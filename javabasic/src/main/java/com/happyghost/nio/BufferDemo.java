package com.happyghost.nio;

import java.nio.ByteBuffer;

public class BufferDemo {

    public static void main(String[] args) {

        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //初始时4个核心变量
        System.out.println("初始时-->limit:" + byteBuffer.limit());
        System.out.println("初始时-->position:" + byteBuffer.position());
        System.out.println("初始时-->capacity:" + byteBuffer.capacity());
        System.out.println("初始时-->mark:" + byteBuffer.mark());

        System.out.println("===========================");

        String s = "hello";
        byteBuffer.put(s.getBytes());

        System.out.println("put完之后-->limit:" + byteBuffer.limit());
        System.out.println("put完之后-->position:" + byteBuffer.position());
        System.out.println("put完之后-->capacity:" + byteBuffer.capacity());
        System.out.println("put完之后-->mark:" + byteBuffer.mark());

        byteBuffer.flip();

        System.out.println("===========================");

        System.out.println("flip完之后-->limit:" + byteBuffer.limit());
        System.out.println("flip完之后-->position:" + byteBuffer.position());
        System.out.println("flip完之后-->capacity:" + byteBuffer.capacity());
        System.out.println("flip完之后-->mark:" + byteBuffer.mark());
        


    }
}
