package com.happyghost.string;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("222", new Object());
        Object put1 = map1.put("111", new Object());
        System.out.println(map1);


        Map<String, Map<String, Object>> first = new HashMap<>();

        Map<String, Object> mapA1 = new HashMap<>();
        mapA1.put("a1", "a1");

        Map<String, Object> mapB1 = new HashMap<>();
        mapB1.put("b1", "b1");

        first.put("f1", mapA1);
        first.put("f2", mapB1);
        System.out.println(first);

    }
}
