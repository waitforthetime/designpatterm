package com.wy.study.java.multithread.objectinit;

import static com.wy.study.java.multithread.objectinit.StaticInClass.*;

/**
 * Created by wy_ms on 2017/05/21.
 */
public class TestDemo {


    public static void main(String[] args) {
//        System.out.println("调用static filed："+ StaticInClass.InnerClass.j);;
        /*System.out.println(new StaticInClass().new InnerClassNoStatic().m);
        StaticInClass s = new StaticInClass();
        StaticInClass.InnerClassNoStatic ss = s.new InnerClassNoStatic();*/
        doSomething();
    }

}
