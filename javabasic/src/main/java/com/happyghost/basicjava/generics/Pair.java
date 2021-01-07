package com.happyghost.basicjava.generics;

public class Pair<T,U> {
    T first;
    U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<String,Integer> pairStr = new Pair<>("age", 100);
        System.out.println(pairStr.getFirst());
        System.out.println(pairStr.getSecond());
    }
}