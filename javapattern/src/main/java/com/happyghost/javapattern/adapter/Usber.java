package com.happyghost.javapattern.adapter;

/**
 * Usb的实现类
 *
 * @author HappyGhost
 * @create 2018-08-19 22:50
 **/
public class Usber implements Usb {
    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}
