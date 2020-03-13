package com.happyghost.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 验证volatile可见性
 * 1.1 假如int number = 0; number 变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2 添加了volatile，可以解决可见性问题
 * <p>
 * 2 验证volatile不保证原子性
 * 2.1  原子性：不可分割，完整性，也即某个线程正在做某个业务时，
 * 中间不可用被加塞或者被分割。需要整体完整，要么同时成功，要么同时失败。
 */
public class VolatileDemo {


    public static void main(String[] args) {
//        seeOkByVolatile();

        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomicInt();
                }

            }).start();
        }

        //需要等待上面20个线程全部计算完成后，再用main线程取得最终结果值是多少？

//        Thread.sleep(5000);

//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomic type finally number value:" + myData.atomicInteger);
    }

    /**
     * volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改。
     */
    public static void seeOkByVolatile() {
        MyData data = new MyData();

        System.out.println("data a初始值：" + data.number);

        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " thread come in");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.modifyA();

            System.out.println("data a修改后的值：" + data.number);

        }, "t1").start();

        //主线程
        while (data.number == 0) {

        }

        System.out.println("主线程   end");
    }

}


class MyData {
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger(0);



    public void modifyA() {
        this.number = 60;
    }

    public void addPlusPlus() {
        this.number++;
    }

    public void addAtomicInt() {
        atomicInteger.getAndIncrement();
    }
}
