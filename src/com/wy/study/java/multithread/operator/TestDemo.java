package com.wy.study.java.multithread.operator;

/**
 * Created by wy_ms on 2017/05/21.
 */
public class TestDemo {
    public static void main(String[] args) {
        int a = 6;
        int b = 4;
        int x = a --- b;
        int y = a- --b;
        int z = a -- - b;
        /*
        x=2
        y=2
        z=2
        */
        System.out.println("x："+x+"  y："+y+" z："+z);
    }
}
