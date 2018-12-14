package com.happyghost.javapattern.interpreter;

import java.util.HashMap;

/**
 * 变量解析器
 * @author HappyGhost
 * @create 2018-12-14 22:56
 **/
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 从map中取
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
