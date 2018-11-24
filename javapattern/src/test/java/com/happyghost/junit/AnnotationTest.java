package com.happyghost.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Junit注解
 *
 * @author HappyGhost
 * @create 2018-11-24 17:17
 **/
public class AnnotationTest {

    /**
     * @Test 将一个方法的普通的方法修饰成一个测试方法
     *      @Test(expected = XXX.class)
     *      @Test(timeout = 3000)
     * @AfterClass
     * @Ignore 忽略测试方法
     */

    @Ignore("xxxx")
    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        assertEquals(3,new Calculate().divide(6, 0));
    }

    @Test(timeout = 2000)
    public void testWhile(){
        while (true) {
            System.out.println("run forever");
        }
    }


}
