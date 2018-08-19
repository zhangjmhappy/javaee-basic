package com.happyghost.javapattern.adapter;

/**
 * 适配器类:类适配器模式
 *
 * @author HappyGhost
 * @create 2018-08-19 22:53
 **/
public class MyAdapter extends Usber implements Ps2{

    @Override
    public void isPs2() {
        isUsb();
    }
}
