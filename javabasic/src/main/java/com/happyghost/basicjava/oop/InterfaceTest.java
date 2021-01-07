package com.happyghost.basicjava.oop;

interface CanFly {
    void fly();
}

interface CanRun {
    void run();
}

class Animal {
    public void getCategory() {
        System.out.println("I'am animal");
    }
}

class Duck extends Animal implements CanFly,CanRun {
    @Override
    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void run() {
        System.out.println("I can run");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.getCategory();
        duck.fly();
        duck.run();
    }
}
