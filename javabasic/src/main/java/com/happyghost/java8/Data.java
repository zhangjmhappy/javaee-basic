package com.happyghost.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author HappyGhost
 * @create 2019-04-09 2:25
 **/
public class Data {
    private static List<UserModel> list ;

    static {
        UserModel zhangSan = new UserModel("zhangSan", 18, "男");
        UserModel liSi = new UserModel("liSi", 20, "女");
        UserModel rose = new UserModel("rose", 30, "女");
        UserModel jack = new UserModel("jack", 25, "男");
        UserModel tom = new UserModel("tom", 40, "男");
        list = Arrays.asList(zhangSan, liSi, rose, jack, tom);

    }

    public static List<UserModel> getData() {
        return list;
    }
}
