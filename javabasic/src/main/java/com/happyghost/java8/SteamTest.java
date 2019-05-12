package com.happyghost.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://mp.weixin.qq.com/s?__biz=MzUxOTAxODc2Mg==&mid=2247484538&idx=1&sn=4139fd9eaea52c1656489623ea27da18&chksm=f981441fcef6cd091727cfc1ff4c1fac2e47a28e6e3b5125b688541430258fdc7206b1420a6b&mpshare=1&scene=1&srcid=0408libeq0ck7Lihm6Hz5N9U#rd
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

    @Test
    public void testGetUserNameList() {
        List<UserModel> data = Data.getData();
        //old
        List<String> list = new ArrayList<>();
        for (UserModel user : data) {
            list.add(user.getName());
        }
        System.out.println(list);

        //new 1
        List<String> collect = data.stream().map(userModel -> userModel.getName()).collect(Collectors.toList());
        System.out.println(collect);

        //new 2
        List<String> collect2 = data.stream().map(UserModel::getName).collect(Collectors.toList());
        System.out.println(collect2);

        //new 3
        List<String> collect3 = data.stream().map(userModel -> {
            System.out.println(userModel.getName());
            return userModel.getName();
        }).collect(Collectors.toList());
        System.out.println(collect3);

    }

    @Test
    public void flatMapString() {
        List<UserModel> data = Data.getData();

        //返回类型不一样
        List<String> collect = data.stream().flatMap(userModel ->
                Arrays.stream(userModel.getName().split(" ")))
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Stream<String>> collect1 = data.stream().map(userModel ->
                Arrays.stream(userModel.getName().split(" ")))
                .collect(Collectors.toList());
        //System.out.println(collect1.stream().flatMap(userModel ->
        //        Arrays.stream(userModel.getName().split(" "))).collect(Collectors.toList()));

        //用map实现
        List<String> collect2 = data.stream().map(userModel ->  userModel.getName().split(" "))
                .flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect2);

        //另一种方式
        List<String> collect3 = data.stream()
                .map(userModel ->  userModel.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream() ).collect(Collectors.toList());
        System.out.println(collect3);


    }




}
