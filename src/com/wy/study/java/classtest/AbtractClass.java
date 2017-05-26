package com.wy.study.java.classtest;

/**
 * Created by wy_ms on 2017/05/25.
 */
public class AbtractClass {

    {
        System.out.println("AbtractClass init");
    }

    private int i;

    public AbtractClass() {
    }

    public AbtractClass(int i) {
        this.i = i;
        System.out.println("初始化数据i："+i);
    }
}
