package com.wy.study.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by wy_ms on 2017/05/16.
 */
public class DuiSort {

    public static void main(String[] args) {

        int size = 10;
        Integer[] queue = {3,5,7,4,8,6,10,9,1,2};
       /* for (int i = (size >>> 1) - 1; i >= 0; i--) {
            int k= i;
            int x = queue[i];
            int half = size >>> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                int c = queue[child];
                int right = child + 1;
                if (right < size &&
                         c> queue[right])
                    c = queue[child = right];
                if (x<= c)
                    break;
                queue[k] = c;
                k = child;
            }
            queue[k] = x;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(queue[i]);
        }*/

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(queue));
        PriorityQueue<Integer> qu = new PriorityQueue<Integer>(list);
        for (int i = 0; i < size; i++) {
            int v = qu.poll();
            System.out.println(v);
        }
    }
}
