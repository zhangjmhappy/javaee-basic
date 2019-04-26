package com.happyghost.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExposeTest {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        Category category = new Category();
        category.setChildren(null);
        category.setId(1);
        category.setName("数码");
        System.out.println(gson.toJson(category));
    }


}
