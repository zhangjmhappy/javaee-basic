package com.happyghost.basicjava.reflect;

import org.junit.Test;
class A{
    static {
        System.out.println("static block");
    }

    {
        System.out.println("dynamic block");
    }
}


public class ClazzTest {
    public static void main(String[] args) throws ClassNotFoundException {



    }

    /**
     * className.class获取class对象
     */
    @Test
    public void test1() {
        Class<?> c = A.class;
        System.out.println("className:"+ c.getName());//className:com.happyghost.basicjava.reflect.A
    }

    /**
     * Class.forName()获取class对象
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> c = null;
        c = Class.forName("com.happyghost.basicjava.reflect.A");
        System.out.println("className:"+ c.getName());
//        static block
//        className:com.happyghost.basicjava.reflect.A
    }

    /**
     * Object.getClass()获取class对象
     */
    @Test
    public void test3() {
        Class<?> c = new A().getClass();
        System.out.println("className:"+ c.getName());
    }
}

