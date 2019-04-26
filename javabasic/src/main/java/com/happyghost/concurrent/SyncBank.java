package com.happyghost.concurrent;

public class SyncBank {

    int count;


    private void addMoney(int money) {
        count += money;
        System.out.println(System.currentTimeMillis() + "存进：" + money);
    }

    private synchronized void subMoney(int money) {

        if (count - money < 0) {
            System.out.println("余额不足");
            return;
        }
        count -= money;
        System.out.println(System.currentTimeMillis() + "取出：" + money);

    }

    private synchronized void showMoney() {
        System.out.println("当前余额" + count);
    }


    public static void main(String[] args) {

        final SyncBank bank = new SyncBank();
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
