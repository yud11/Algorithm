package com.h3c.algorithm;

import java.util.Arrays;

/**
 * @author yudi
 * @date 2020-02-06 21:40
 * Description 使用数组实现容量大小无限的动态数组
 */
public class ArrayList<E> {


    Object[] array = new Object[16];

    private  int N = 0;

    /**
     * 返回集合中元素的数量
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 集合是否为空
     * @return
     */
    public boolean isEmpty(){
        return 0 == N;
    }

    /**
     * 添加元素
     * @param element 元素
     */
    public void add(E element){
        if (N > array.length) {
            array = Arrays.copyOf(array, 2 * N);
        }
        array[N++] = element;
    }

    public E get(int index){
       return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }

    public E remove(int index){
        return null;
    }

    public int indexOf(E element){
        return 0;
    }


    public void clear(){

    }


}
