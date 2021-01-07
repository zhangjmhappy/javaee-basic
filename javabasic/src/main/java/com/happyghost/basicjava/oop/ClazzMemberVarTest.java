package com.happyghost.basicjava.oop;

/**
 * 类中成员变量没有多态的概念
 */
public class ClazzMemberVarTest {

    public static void main(String[] args) {
        Base1 base1 = new Sub1();
        System.out.println(base1.i);//结果为1
    }
}

class Base1 {
    public int i = 1;
}

class Sub1 extends Base1 {

    public int i = 20;
}

