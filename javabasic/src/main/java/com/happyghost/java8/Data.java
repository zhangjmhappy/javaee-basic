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
        UserModel zhangSan = new UserModel("zhangSan", 18, "男",2000);
        UserModel liSi = new UserModel("liSi", 20, "女",3000);
        UserModel rose = new UserModel("rose", 25, "女",5000);
        UserModel jack = new UserModel("jack", 30, "男",10000);
        UserModel tom = new UserModel("tom", 40, "男",12000);
        UserModel wangwu = new UserModel("wangwu", 50, "男",8000);
        list = Arrays.asList(zhangSan, liSi, rose, jack, tom,wangwu);

    }

    public static List<UserModel> getData() {
        return list;
    }
}
