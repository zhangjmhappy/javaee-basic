package com.happyghost.basicjava.oop;

/**
 * 让这些内部类继承自不同的父类，这样可以通过这些内部类来访问不同类的方法
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.c();
        computer.m();
    }
}

class Memory {

    public void m() {
        System.out.println("Memory");
    }
}

class CPU {

    public void c() {
        System.out.println("CPU");
    }
}

class Computer {

    class Memory1 extends Memory {

    }

    class CPU1 extends CPU {
    }

    public void m() {
        new Memory1().m();
    }


    public void c() {
        new CPU1().c();
    }
}
