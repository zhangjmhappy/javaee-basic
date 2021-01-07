package com.happyghost.basicjava.generics;

/**
 * 参数类型限定：上界为某个具体类
 *
 * @param <U>
 * @param <V>
 */
public class NumberPair<U extends Number, V extends Number>
        extends Pair<U, V> {
    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum() {
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        NumberPair<Integer, Double> pair = new NumberPair<>(10, 5.26);
        double sum = pair.sum();
        System.out.println("sum:" + sum);
    }


}