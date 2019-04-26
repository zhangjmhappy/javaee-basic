package com.happyghost.concurrent;

public class Bank {

    private int count;


    public void addMoney(int money) {
        count += money;
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    public void subMoney(int money) {

        if (count - money < 0) {
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(System.currentTimeMillis() + "取出：" + money);

    }

    private void showMoney() {
        System.out.println("当前余额" + count);
    }


    public static void main(String[] args) {

        final Bank bank = new Bank();
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
