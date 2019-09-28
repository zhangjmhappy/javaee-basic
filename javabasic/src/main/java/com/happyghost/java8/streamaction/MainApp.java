package com.happyghost.java8.streamaction;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 * @author HappyGhost
 * @create 2019-09-29 0:48
 **/
public class MainApp {

    List<Transaction> listData ;

    @Before
    public void  initData() {
        Trader jack = new Trader("jack","beijing");
        Trader rose = new Trader("rose", "shanghai");
        Trader ming = new Trader("ming", "beijing");
        Trader hong = new Trader("hong", "beijing");
        listData = Arrays.asList(
                new Transaction(hong, 2018, 300),
                new Transaction(jack, 2019, 1000),
                new Transaction(jack, 2018, 400),
                new Transaction(rose, 2019, 710),
                new Transaction(rose, 2019, 700),
                new Transaction(ming, 2019, 950)
        );
    }

    /**
     * 找出2018年发生的所有交易，并按交易额排序（从低到高）
     */
    @Test
    public void test01() {
        System.out.println("找出2018年发生的所有交易，并按交易额排序（从低到高）");
        List<Transaction> tras2018 = listData.stream()
                .filter(transaction -> transaction.getYear() == 2018)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        tras2018.forEach(System.out::println);
    }

    private void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    /**
     * 交易员都在哪些不同的城市工作过
     */
    @Test
    public void test02() {
        List<String> cityNames = listData.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        cityNames.forEach(System.out::println);

        //或者使用set
        Set<String> cityNames2 = listData.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        cityNames2.forEach(System.out::println);

    }

    /**
     * 查找所有来自北京的交易员，并按姓名排序
     */
    @Test
    public void test03() {
        List<Trader> beijList = listData.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("beijing"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        printList(beijList);
    }


    /**
     * 返回所有交易员的姓名字符串，按字母排序
     */
    @Test
    public void test04() {
        System.out.println("返回所有交易员的姓名字符串，按字母排序");
        List<String> tras2018 = listData.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        printList(tras2018);
    }


    /**
     * 查询有没有交易在上海的员工
     */
    @Test
    public void test05() {
        System.out.println("查询有没有交易在上海的员工");
        boolean ifExist = listData.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("shanghai"));
        System.out.println("查询有没有交易在上海的员工:" + (ifExist ? "有":"没有"));
    }

    /**
     * 北京交易员的所有交易额
     */
    @Test
    public void test06() {
        System.out.println("北京交易员的所有交易额");
        listData.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("beijing"))
                .map(Transaction::getValue).forEach(System.out::println);
    }

    /**
     * 所有交易中，最高的交易额
     */
    @Test
    public void test07() {
        System.out.println("所有交易中，最高的交易额");
        Optional<Integer> heightValue = listData.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(heightValue.get());
    }

    /**
     * 找出交易额最小的交易单
     */
    @Test
    public void test08() {
        Optional<Transaction> minTrans = listData.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(minTrans.get());
    }


    /**
     * 所有交易中，总计交易额
     */
    @Test
    public void testSum() {
        System.out.println("所有交易中，总计交易额");
        Optional<Integer> heightValue = listData.stream()
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(heightValue.get());

        int sumValue = listData.stream().mapToInt(Transaction::getValue).sum();
        System.out.println(sumValue);

    }




}
