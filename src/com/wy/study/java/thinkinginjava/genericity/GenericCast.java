package com.wy.study.java.thinkinginjava.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class GenericCast {

    public static int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> fixed = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            fixed.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = fixed.pop();
            System.out.print(s+" ");
        }
    }

}


class FixedSizeStack<T> {
    private int index = 0;
    private Object[] objects;

    public FixedSizeStack(int size) {
        this.objects = new Object[size];
    }

    public void push(T item) {
        objects[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) objects[--index];
    }
}

class FixedSizeStackByList<T extends FixedSizeStack<T>> {
    private List<T> list;

    public FixedSizeStackByList() {
        this.list = new ArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (!list.isEmpty()) {
            return list.remove(list.size()-1);
        }
        return null;
    }
}
