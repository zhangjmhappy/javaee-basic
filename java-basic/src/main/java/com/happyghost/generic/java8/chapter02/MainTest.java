package com.happyghost.generic.java8.chapter02;

/**
 * @author HappyGhost
 * @create 2018-09-16 13:34
 **/
public class MainTest {

    public static void main(String[] args) {

        Thread t = new Thread(() ->
                System.out.println("HelloWorld"));

        t.start();


    }

}
