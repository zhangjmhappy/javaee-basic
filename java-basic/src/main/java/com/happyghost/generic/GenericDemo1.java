package com.happyghost.generic;

/**
 * 一个泛型demo
 *
 * @author HappyGhost
 * @create 2018-09-15 17:00
 **/
public class GenericDemo1<T> {

    public <T> T genericMethod(Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        GenericDemo1<String> str = new GenericDemo1<>();

        Object appStr = str.genericMethod(Class.forName("java.lang.String"));
        System.out.println(appStr.toString());



    }


}
