package com.happyghost.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * https://juejin.im/post/5af942c6f265da0b7026050c
 */
public class SimpleFileTransferTest {

    private long transferFile(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();
        if (des.exists()) {
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        //将数据源读到的内容写入目的地--使用数组
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes,0,len);
        }

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (des.exists()) {
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

        while (readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();


        long costTime = System.currentTimeMillis() - startTime;
        return costTime;
    }

    public static void main(String[] args) throws IOException {
        fileCopy("E:\\test01.mp4","F:\\test01_io.mp4","F:\\test01_nio.mp4");
        fileCopy("E:\\test02.mp4","F:\\test02_io.mp4","F:\\test02_nio.mp4");

    }

    private static void fileCopy(String sourceStr,String ioDesStr,String nioDesStr) throws IOException {
        SimpleFileTransferTest simpleFileTransferTest = new SimpleFileTransferTest();
        File source = new File(sourceStr);
        File des = new File(ioDesStr);
        File nioDes = new File(nioDesStr);

        long time = simpleFileTransferTest.transferFile(source, des);
        System.out.println("普通IO字节流消耗时间：" + time + "ms");

        long nioTime = simpleFileTransferTest.transferFileWithNIO(source, nioDes);
        System.out.println("NIO消耗时间：" + nioTime + "ms");
    }


}
