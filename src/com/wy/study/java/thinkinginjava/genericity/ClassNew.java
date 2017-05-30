package com.wy.study.java.thinkinginjava.genericity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class ClassNew {

    private String a;
    private String b;

    public ClassNew(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return a+ "===" + b;
    }

    public static void main(String[] args) {
        Constructor<?>[] con = ClassNew.class.getConstructors();
        try {
            ClassNew r = (ClassNew) con[0].newInstance("1", "2");
            System.out.println(r);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
