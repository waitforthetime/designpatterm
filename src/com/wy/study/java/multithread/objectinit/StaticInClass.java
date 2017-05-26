package com.wy.study.java.multithread.objectinit;

/**
 * Created by wy_ms on 2017/05/21.
 */
public class StaticInClass {

    static int i = 100;
    final static int k = 1000;

    static {
        System.out.println("static class init");
    }

    public final static void doSomething() {
        System.out.println("类有没有被初始化呢？");
    }

    static class InnerClass {

        static int j = 200;
        static {
            System.out.println("Innet class init");
        }

    }

    public class InnerClassNoStatic{

        int m = 100;
        {
            System.out.println("InnerClassNoStatic init");
        }

    }

}
