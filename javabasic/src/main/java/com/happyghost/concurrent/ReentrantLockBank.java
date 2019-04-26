package com.happyghost.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBank {

    int count;

    private Lock lock = new ReentrantLock();


    private void addMoney(int money) {
        lock.lock();//上锁
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);
        } finally {
            lock.unlock();//解锁
        }
    }

    private void subMoney(int money) {
        lock.lock();//上锁
        try {
            if (count - money < 0) {
                System.out.println("余额不足");
                return;
            }
            count -= money;
            System.out.println(System.currentTimeMillis() + "取出：" + money);
        } finally {
            lock.unlock();//解锁
        }
    }

    private void showMoney() {
        System.out.println("当前余额" + count);
    }


    public static void main(String[] args) {

        final ReentrantLockBank bank = new ReentrantLockBank();
        Thread addThread = new Thread(new Runnable() {
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.showMoney();
                    System.out.println("\n");
                }

            }
        });


        Thread subThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    bank.subMoney(100);
                    bank.showMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        subThread.start();
        addThread.start();
    }
}
