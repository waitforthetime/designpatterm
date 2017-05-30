package com.wy.study.java.thinkinginjava.genericity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class ArrayCovariant {

    public static void main(String[] args) {
        Number[] nums = new Integer[10];

        for (int i = 0; i < 10; i++) {
            nums[i] = i+1;
        }
        System.out.println(Arrays.toString(nums));

        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        List<? extends Number> list = l;
        for (Number n : list) {
            System.out.println(n);
        }
        System.out.println(list.indexOf(1));
    }

}
