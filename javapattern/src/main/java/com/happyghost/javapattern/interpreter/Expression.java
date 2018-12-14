package com.happyghost.javapattern.interpreter;

import java.util.HashMap;

/**
 * 抽象表达类
 * @author HappyGhost
 * @create 2018-12-14 22:52
 **/
public abstract class Expression {
    //解析公式和数值，其中var中的key值是公式中的参数，value是具体的数字
    public abstract int interpreter(HashMap<String, Integer> var);
}
