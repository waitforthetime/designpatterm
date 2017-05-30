package com.wy.study.java.thinkinginjava.genericity;

import java.util.Collections;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class CRG {

    public static void main(String[] args) {

        People p1 = new People(), p2 = new People();
        People p3 = p1.married(p2);
        p3.married(p1);
        Marray p4 = p1.married(p2);
        System.out.println(p4);
    }

}

abstract class Marray<T extends Marray<T>> {

    private static int count = 0;
    private final int id = count++;

    T married(T marray) {
        System.out.println(this + " marray to "+marray);
        return marray;
    }

    protected abstract T marray(T marray);

    public String toString() {
        return "id："+id;
    }
}

class People extends Marray<People> {

    @Override
    protected People marray(People marray) {
        return marray;
    }
}