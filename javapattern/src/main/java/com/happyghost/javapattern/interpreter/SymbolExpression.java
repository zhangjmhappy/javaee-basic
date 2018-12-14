package com.happyghost.javapattern.interpreter;

import java.util.HashMap;

/**
 * 抽象运算符号解析器
 *
 * @author HappyGhost
 * @create 2018-12-14 22:58
 **/
public class SymbolExpression extends Expression{

    protected Expression left;

    protected Expression right;

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
