package com.wy.study.java.thinkinginjava.genericity;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class ArrayMaketr <T> {
    private Class<T> kind;

    public ArrayMaketr(Class<T> kind) {
        this.kind = kind;
    }
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }


    public static void main(String[] args) {
        ArrayMaketr<String> maketr = new ArrayMaketr<>(String.class);
        String[] strings = maketr.create(10);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString((Integer[])Array.newInstance(Integer.class, 10)));
    }
}
