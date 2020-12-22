package com.happyghost.basicjava.valueRef;

import com.happyghost.utils.ObjectUtils;

public class ValueTest {

    public static void testPassParameter(StringBuffer ss1, int n) throws NoSuchFieldException, IllegalAccessException {
        ss1.append("World");
        ObjectUtils.printAddresses("ss1",ss1);
        n = 8;
        ObjectUtils.printAddresses("n",n);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int i = 1;
        StringBuffer s1 = new StringBuffer("Hello");
        ObjectUtils.printAddresses("s1",s1);
        ObjectUtils.printAddresses("i",i);
        testPassParameter(s1, i);
        System.out.println(s1);
        System.out.println(i);
    }
}
