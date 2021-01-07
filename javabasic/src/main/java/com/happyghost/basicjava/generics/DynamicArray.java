package com.happyghost.basicjava.generics;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 上行限定
     * @param c
     * @param <T>
     */
    public <T extends E> void addAll(DynamicArray<T> c) {
        for(int i=0; i<c.size; i++){
            add(c.get(i));
        }
    }

    public  void addAll2(DynamicArray<? extends E> c) {
        for(int i=0; i<c.size; i++){
            add(c.get(i));
        }
    }


    /**
     * 通配符 ? ：重要的限制：只能读，不能写。
     * @param arr
     * @param i
     * @param j
     */
//    public static void swap(DynamicArray<?> arr, int i, int j){
//        Object tmp = arr.get(i);
//        arr.set(i, arr.get(j));//编译错误，set非法
//        arr.set(j, tmp);//编译错误，set非法
//    }

    private static <T> void swapInternal(DynamicArray<T> arr, int i, int j){
        T tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }
    public static void swap(DynamicArray<?> arr, int i, int j){
        swapInternal(arr, i, j);
    }


    public void copyTo(DynamicArray<? super E> dest){
        for(int i=0; i<size; i++){
            dest.add(get(i));
        }
    }

    public static void main(String[] args) {


        DynamicArray<Double> arr = new DynamicArray<Double>();
        Random rnd = new Random();
        int size = 1+rnd.nextInt(100);
        System.out.println(size);
        for(int i=0; i<size; i++){
            arr.add(Math.random());
        }
        Double d = arr.get(rnd.nextInt(size));
        System.out.println(d);



//        DynamicArray<Number> numbers = new DynamicArray<>();
//        DynamicArray<Integer> ints = new DynamicArray<>();
//        ints.add(100);
//        ints.add(34);
//        numbers.addAll(ints); //会提示编译错误
//        numbers.addAll2(ints);

//        DynamicArray<Integer> ints = new DynamicArray<>();
//        DynamicArray<? extends Number> numbers = ints;
//        Integer a = 200;
//        numbers.add(a);



    }

    @Test
    public void testSuper() {
        DynamicArray<Integer> ints = new DynamicArray<Integer>();
        ints.add(100);
        ints.add(34);
        DynamicArray<Number> numbers = new DynamicArray<Number>();
        ints.copyTo(numbers);
    }
}