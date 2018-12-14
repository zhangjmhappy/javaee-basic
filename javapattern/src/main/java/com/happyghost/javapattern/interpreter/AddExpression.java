package com.happyghost.javapattern.interpreter;

import java.util.HashMap;

/**
 * 加法解析器
 *
 * @author HappyGhost
 * @create 2018-12-14 23:01
 **/
public class AddExpression extends SymbolExpression {


    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 左右2个表达式运算的结果加起来
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }


}
