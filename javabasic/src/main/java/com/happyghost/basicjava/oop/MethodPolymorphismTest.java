package com.happyghost.basicjava.oop;

/**
 * 成员方法多态性
 */
public class MethodPolymorphismTest {
    public static void main(String[] args) {
        Base b = new Sub();
        b.f();
        b.g();

    }
}

class Base {
    public Base(){
        g();
    }

    public void f() {
        System.out.println("Base.f()");
    }

    public void g() {
        System.out.println("Base.g()");
    }
}

class Sub extends Base {

    public void f() {
        System.out.println("Sub.f()");
    }

    public void g() {
        System.out.println("Sub.g()");
    }
}