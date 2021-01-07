package com.happyghost.basicjava.generics;

/**
 * 泛型方法，不需要在泛型类中，与它所在的类是不是泛型没有什么关系
 */
public class GenericsMethodTest {

    public static <T> int indexOf(T[] arr, T element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }


    public static <U,V> Pair<U,V> makePair(U first, V second){
        Pair<U,V> pair = new Pair<>(first, second);
        return pair;
    }

    public static void main(String[] args) {
        System.out.println(indexOf(new Integer[]{1, 3, 5}, 3));

        System.out.println(makePair(1, "jack").getFirst());
        System.out.println(makePair("name", "111").getSecond());
    }
}
