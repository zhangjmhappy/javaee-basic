package com.happyghost.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HappyGhost
 * @create 2019-04-09 2:18
 **/
public class SteamTest {


    @Test
    public void testFilter() {

        List<UserModel> data = Data.getData();

        List<UserModel> collect = data.stream()
                .filter(userModel -> "男".equals(userModel.getSex()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

}
