package com.happyghost.javapattern.adapter.interface_adapter;

/**
 * A实现A类
 *
 * @author HappyGhost
 * @create 2018-08-19 23:16
 **/
public class Aimpl extends Adapter {

    @Override
    public void methodA() {
        System.out.println("A方法实现中。。。");
    }

    @Override
    public void methodB() {
        System.out.println("B方法实现中。。。");
    }
}
