package com.wy.study.java.multithread;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/15.
 */
public class AutoPackAndUnPack {

    public static void main(String[] args) {
       /* Integer a =1;
        Integer b =2;
        Integer c =3;
        Integer d =3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));*/
       /* List<Integer> list = Arrays.asList(1,2,3,4);
        int sum = 0;
        int count = 0;
        for (int i : list) {
            sum += i;
            count = sum + i -1 ;
        }
        System.out.println(sum);*/

       int[] i = new int[10];
        for (int j = 0; j < 10; j++) {
            i[j] = j;
        }
        for (int k : i) {
            System.out.println(k);
        }
    }
}
