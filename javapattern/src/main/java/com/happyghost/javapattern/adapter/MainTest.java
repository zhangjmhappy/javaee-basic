package com.happyghost.javapattern.adapter;

/**
 * 参考：https://www.cnblogs.com/V1haoge/p/6479118.html
 * <p>
 * 我手中有个ps2插头的设备，但是主机上只有usb插头的插口，怎么办呢？弄个转换器，将ps2插头转换成为USB插头就可以使用了。
 * <p>
 * 　　接口Ps2：描述ps2接口格式
 * <p>
 * 　　接口Usb：描述USB接口格式
 * <p>
 * 　　类Usber：是接口Usb的实现类，是具体的USB接口格式
 * <p>
 * 　　Adapter：用于将ps2接口格式转换成为USB接口格式
 * 类适配器
 * 测试类
 *
 * @author HappyGhost
 * @create 2018-08-19 22:56
 **/
public class MainTest {
    public static void main(String[] args) {
        Ps2 ps2 = new MyAdapter();
        ps2.isPs2();
    }
}
