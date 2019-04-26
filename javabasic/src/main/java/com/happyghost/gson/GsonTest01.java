package com.happyghost.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonTest01 {

    public static void main(String[] args) {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);
        System.out.println(i);

        double d = gson.fromJson("\"99.99\"", double.class);
        System.out.println(d);


        User user = new User("盖伦1", 20, "fastGson@qq.com");

        String jsonObject = gson.toJson(user);
        System.out.println(jsonObject);

        //GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.create().
        String userJsonStr = "{\"name\":\"盖伦1\",\"age\":20,\"emailAddress\":\"fastGson@qq.com\"}";
        User user02 = gson.fromJson(userJsonStr, User.class);
        System.out.println("user02" + user02.toString());

        //language=JSON
        String userJsonStr3 = "{\"name\":\"盖伦1\",\"age\":20,\"emailAddress\":\"fastGson@qq.com\",\"email\":\"fastGson2@qq.com\",\"emailAddress\":\"fastGson3@qq.com\"}";
        User user3 = gson.fromJson(userJsonStr3, User.class);
        System.out.println("user3" + user3.toString());


        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);

        for (String item : strings) {

            System.out.println(item);
        }

        //泛型擦除
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {
        }.getType());

        for (String item : stringList) {

            System.out.println(item);
        }


    }


}
