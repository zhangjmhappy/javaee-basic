package com.happyghost.junit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 计算类测试
 *
 * @author HappyGhost
 * @create 2018-11-24 16:42
 **/
public class CalculateTest {

    @Test
    public void testAdd() {
        assertEquals(6,new Calculate().add(3,3));
    }

    @Test
    public void testSubstract(){
        assertEquals(3 ,new Calculate().substract(5,2));
    }

    @Test
    public void testMultiply() {
        assertEquals(4, new Calculate().multiply(2, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(3,new Calculate().divide(6,2));
    }


}
