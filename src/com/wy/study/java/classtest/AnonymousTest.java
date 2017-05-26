package com.wy.study.java.classtest;

/**
 * Created by wy_ms on 2017/05/25.
 */
public class AnonymousTest {

    public static Object innerClass() {
        return new AbtractClass(10) {

            {
                System.out.println("innerClass init");
            }

        };
    }

    public static void main(String[] args) {
        innerClass();
    }

}
