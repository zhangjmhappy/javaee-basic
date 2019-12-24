package com.happyghost.java8.parallel;

import java.util.stream.Stream;

/**
 * @author HappyGhost
 * @create 2019-09-26 23:02
 **/
public class ParallelDemo {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(sequentialSum(100));
    }
}
