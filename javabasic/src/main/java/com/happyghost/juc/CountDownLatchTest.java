package com.happyghost.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(4);


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }).start();

        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("3");

        long millis = ((int)(1+Math.random()*5)) * 1000;
        System.out.println(millis);
    }
}
