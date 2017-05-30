package com.wy.study.java.thinkinginjava.genericity;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class GenericArray<T> {

    private T[] r;

    public GenericArray(Class<T> tClass,int size) {
        r = (T[]) Array.newInstance(tClass,size);
    }

    public void add(int index, T t) {
        r[index] = t;
    }

    public T get(int index) {
        return r[index];
    }

    public T[] getarray() {
        return r;
    }

    public static void main(String[] args) {
        GenericArray<Integer> tarr = new GenericArray<>(Integer.class,10);
        tarr.add(0,1);
        tarr.add(2,3);
        tarr.add(3,4);
        tarr.add(4,5);
        Integer[] arr = tarr.getarray();
        System.out.println(Arrays.toString(arr));


    }

}
