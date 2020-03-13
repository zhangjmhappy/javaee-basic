package com.happyghost.thread.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private int i = 0;

    //与run不同的是，call具有返回值
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (; i< 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i );
            sum += i;
        }
        return sum;
    }
}
