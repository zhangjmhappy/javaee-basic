package com.happyghost.thread.callable.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolDemo {

    public static void main(String[] args) {


        System.out.println(Runtime.getRuntime().availableProcessors());

        /**
         * AbortPolicy : 直接抛出RejectedExecutionException异常阻止系统正常运行.
         *
         * CallerRunsPolicy: "调用者运行"一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，
         *          从而降低新任务的流量。
         *
         * DiscardPolicy: 改策略摸摸的丢弃无痕处理的任务，不予以任何处理也不抛出异常，如果允许任务丢失，这是最好的一种策略。
         *
         * DiscardOldestPolicy:抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务。
         *
         */
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {

            for (int i = 0; i < 10; i++) {
//                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务"));

            }

//            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }

    public void initThreadPool() {
        //一池5个工作线程，类似一个银行的有5个受理窗口
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        //一池1个工作线程，类似一个银行的有1个受理窗口
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池n个工作线程，类似一个银行的有n个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool();



        try {

            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 办理业务"));

            }

//            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
