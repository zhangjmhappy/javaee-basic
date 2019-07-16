package com.happyghost.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStreamTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3,10, 5, 6);
        List<Integer> number = list.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        number.forEach(System.out::println);

        List<UserModel> userModels = Data.getData();

        List<UserModel> userModels1 = userModels.stream().sorted(Comparator.comparing(UserModel::getAge).reversed()).collect(Collectors.toList());

        userModels1.forEach(UserModel::getAge);

        for (UserModel userModel : userModels1) {
            System.out.println(userModel.getName()+" " + userModel.getAge());
        }

        for (UserModel userModel : userModels1) {
            System.out.println(userModel.getName()+" " + userModel.getAge());
        }



    }
}
