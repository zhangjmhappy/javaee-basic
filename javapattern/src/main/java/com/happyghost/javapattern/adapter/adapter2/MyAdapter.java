package com.happyghost.javapattern.adapter.adapter2;

/**
 * 适配器类:对象适配器模式
 *
 * @author HappyGhost
 * @create 2018-08-19 22:53
 **/
public class MyAdapter implements Ps2 {

    private Usb usb;

    public MyAdapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void isPs2() {
        usb.isUsb();
    }
}
