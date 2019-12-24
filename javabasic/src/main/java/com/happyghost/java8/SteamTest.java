package com.happyghost.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://mp.weixin.qq.com/s?__biz=MzUxOTAxODc2Mg==&mid=2247484538&idx=1&sn=4139fd9eaea52c1656489623ea27da18&chksm=f981441fcef6cd091727cfc1ff4c1fac2e47a28e6e3b5125b688541430258fdc7206b1420a6b&mpshare=1&scene=1&srcid=0408libeq0ck7Lihm6Hz5N9U#rd
 *
 * @author HappyGhost
 * @create 2019-04-09 2:18
 **/
public class SteamTest {


    @Test
    public void testFilter() {

        List<UserModel> data = Data.getData();
        List<UserModel> collect = data.stream()
                .filter(userModel -> "男".equals(userModel.getSex()))
                .collect(toList());
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
        List<String> collect = data.stream().map(userModel -> userModel.getName()).collect(toList());
        System.out.println(collect);

        //new 2
        List<String> collect2 = data.stream().map(UserModel::getName).collect(toList());
        System.out.println(collect2);

        //new 3
        List<String> collect3 = data.stream().map(userModel -> {
            System.out.println(userModel.getName());
            return userModel.getName();
        }).collect(toList());
        System.out.println(collect3);

    }

    @Test
    public void flatMapString() {
        List<UserModel> data = Data.getData();

        //返回类型不一样
        List<String> collect = data.stream().flatMap(userModel ->
                Arrays.stream(userModel.getName().split(" ")))
                .collect(toList());
        System.out.println(collect);

        List<Stream<String>> collect1 = data.stream().map(userModel ->
                Arrays.stream(userModel.getName().split(" ")))
                .collect(toList());
        //System.out.println(collect1.stream().flatMap(userModel ->
        //        Arrays.stream(userModel.getName().split(" "))).collect(Collectors.toList()));

        //用map实现
        List<String> collect2 = data.stream().map(userModel -> userModel.getName().split(" "))
                .flatMap(Arrays::stream).collect(toList());
        System.out.println(collect2);

        //另一种方式
        List<String> collect3 = data.stream()
                .map(userModel -> userModel.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(toList());
        System.out.println(collect3);


    }

    /**
     *
     */
    @Test
    public void test() {

        List<String> userNames = Arrays.asList("jack", "rose", "gall");
        Stream<String> s = userNames.stream();
        s.forEach(System.out::println);
        //出现错误，流只能被消费一次
        s.forEach(System.out::println);

    }

    /**
     * filter和map循环输出，循环合并输出
     * <p>
     * filtering ==>zhangSan
     * mapping ==>zhangSan
     * filtering ==>liSi
     * mapping ==>liSi
     * filtering ==>rose
     * mapping ==>rose
     * [zhangSan, liSi, rose]
     */
    @Test
    public void test02() {
        List<UserModel> data = Data.getData();

        List<String> names = data.stream().filter(userModel -> {
                    System.out.println("filtering ==>" + userModel.getName());
                    return userModel.getAge() > 0;
                }
        ).map(userModel -> {
            System.out.println("mapping ==>" + userModel.getName());
            return userModel.getName();
        }).limit(3).collect(toList());
        System.out.println(names);
    }

    /**
     * 筛选各异的元素
     */
    @Test
    public void test03() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test04() {

        List<UserModel> data = Data.getData();

        List<Integer> nameLengths = data.stream().filter(userModel -> userModel.getAge() > 20
        ).map(UserModel::getName).map(String::length).collect(toList());

        nameLengths.forEach(System.out::println);



    }

    /**
     *
     */
    @Test
    public void test05() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> aaa = words.stream().map(word -> word.split("")).distinct().collect(toList());

        for (String[] sitem : aaa) {
            System.out.println(Arrays.asList(sitem));
        }
//        [H, e, l, l, o]
//        [W, o, r, l, d]

        List<String> bbb = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(bbb); //[H, e, l, o, W, r, d]

//        for (String bbbStr : bbb) {
//            System.out.println(bbbStr);
//        }

        //给定一组数的平方
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
        System.out.println(squares);

        //对数[1,2,3]和[3,4]
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
        System.out.println("得到的数组对数");
        for (int[] pair : pairs) {
            System.out.println(pair[0]+"," + pair[1]);
        }

        List<int[]> pairs2 = numbers1.stream().flatMap(i -> numbers2.stream()
                                                        .filter(j -> ( i + j) % 3 ==0)  //筛选为被3整除
                                                        .map(j -> new int[]{i, j})
                                                    ).collect(toList());

        System.out.println("筛选为被3整除数组对数");
        for (int[] pair : pairs2) {
            System.out.println(pair[0]+"," + pair[1]);
        }



    }




    @Test
    public void test06() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
        System.out.println(squares);
        //[1, 4, 9, 16, 25]
    }

    @Test
    public void testMatchAndFind() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7);
        if (numbers.stream().anyMatch(n -> n < 10)) {
            System.out.println("找到元素");
        } else {
            System.out.println("没有找到元素");
        }


        List<Integer> numbers2 = Arrays.asList(1, 2, 4, 5, 6, 7);

        if (numbers.stream().allMatch(n -> n < 10)) {
            System.out.println("找到元素");
        } else {
            System.out.println("没有找到元素");
        }

        System.out.println(numbers.stream().findAny().orElse(0));

    }

    /**
     * 计算所有人都的薪水总和
     */
    @Test
    public void testReduce() {
        List<UserModel> data = Data.getData();
        //List<Integer> salaries = data.stream().map(UserModel::getSalary).collect(toList());

        int allSalary = data.stream().map(UserModel::getSalary).reduce(0, (a, b) -> a + b);
        System.out.println("总薪水是：" + allSalary);

        int salary = data.stream().map(UserModel::getSalary).reduce(0, Integer::sum);
        System.out.println(salary);

        int salary2 = data.stream().mapToInt(UserModel::getSalary).sum();
        System.out.println(salary2);

        IntStream intStream = data.stream().mapToInt(UserModel::getSalary);

        Stream<Integer> stream = intStream.boxed();

        //最大薪水
        OptionalInt maxSalary = data.stream().mapToInt(UserModel::getSalary).max();
        int max = maxSalary.orElse(1);

    }

    @Test
    public void testReduceMax() {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        max.ifPresent(System.out::println);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);
    }

    @Test
    public void testRangeClosed() {
        IntStream eventNums = IntStream.range(1, 100).filter(i -> i % 2 == 0);
        IntStream eventNums2 = IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0);
        //49
        System.out.println(eventNums.count());
        //50
        System.out.println(eventNums2.count());
    }

    @Test
    public void testStreamCreate() {

    }

    public static void main(String[] args) {

    }

}
