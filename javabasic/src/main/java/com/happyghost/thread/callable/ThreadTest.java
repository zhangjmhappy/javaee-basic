package com.happyghost.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {
        Callable<Integer> myCallable = new  MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i );
            if (i == 30) {
                Thread thread = new Thread(futureTask);
                thread.start();
            }
        }
        System.out.println("主线程for循环执行完毕。。。");

        try {
            int sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
