package com.wy.study.java.thinkinginjava.genericity;

import java.util.*;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class New {

    public static <K,V> Map<K,V> map() {
        return new HashMap<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        f(New.map());
        List<Integer> il = new ArrayList<>();
        List<String> sl = new ArrayList<>();
        System.out.println(Arrays.toString(il.getClass().getTypeParameters()));
    }

    static void f(Map<String, List<?>> p) {

    }
}
