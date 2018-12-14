package com.happyghost.javapattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

/**
 * @author HappyGhost
 * @create 2018-12-14 23:17
 **/
public class MainApp {

    public static void main(String[] args) throws IOException {
        String exStr = getExpStr();
        HashMap<String, Integer> var = getValue(exStr);
        Calculator calc = new Calculator(exStr);
        System.out.println("运算结果为："+exStr+"="+calc.run(var));
    }


    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static HashMap<String, Integer> getValue(String exStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : exStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.println("111");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }




}
