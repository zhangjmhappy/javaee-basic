package com.happyghost.javapattern.adapter.interface_adapter;

/**
 * @author HappyGhost
 * @create 2018-08-19 23:18
 **/
public class MainTest {
    public static void main(String[] args){
        A a = new Aimpl();
        a.methodA();
        a.methodB();
        a.methodD();
    }
}
