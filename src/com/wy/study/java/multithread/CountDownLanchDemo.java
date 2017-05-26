package com.wy.study.java.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by wy_ms on 2017/05/08.
 */
public class CountDownLanchDemo {

    public static void main(String[] args) {

//        normalTest(10);
//        Mytest(10);
        LockSupport.unpark(Thread.currentThread());
    }

    static class L<T> extends ArrayList<T> {

        @Override
        public void removeRange(int fromIndex, int toIndex) {
            super.removeRange(fromIndex, toIndex);
        }
    }

    public static void Mytest(int count) {
        try {
            CountDownLatch startCount = new CountDownLatch(1);
            CountDownLatch endCount = new CountDownLatch(count);
            for (int i = 0; i < count+1; i++) {
                new Thread(new CountDownRun(startCount, endCount, "" + i)).start();
            }
            System.out.println("线程的小伙伴还没开始呢，都在等我呢,"+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("该让小伙伴干事了，"+System.currentTimeMillis());
            startCount.countDown();
            System.out.println("我要等小伙伴都干完了，我在干,"+System.currentTimeMillis());
            endCount.await();
            System.out.println("我要开始干事了，"+System.currentTimeMillis());

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void normalTest(int count) {
        try {
            CountDownLatch startCount = new CountDownLatch(1);
            CountDownLatch endCount = new CountDownLatch(count);
            for (int i = 0; i < count; i++) {
                new Thread(new CountDownRun(startCount, endCount, "" + i)).start();
            }
            System.out.println("线程的小伙伴还没开始呢，都在等我呢,"+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("该让小伙伴干事了，"+System.currentTimeMillis());
            startCount.countDown();
            System.out.println("我要等小伙伴都干完了，我在干,"+System.currentTimeMillis());
            endCount.await();
            System.out.println("我要开始干事了，"+System.currentTimeMillis());

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    static class CountDownRun implements Runnable {

        CountDownLatch startCount;
        CountDownLatch endCount;
        String name;

        public CountDownRun(CountDownLatch startCount, CountDownLatch endCount, String name) {
            this.startCount = startCount;
            this.endCount = endCount;
            this.name = name;
        }

        @Override
        public void run() {

            try {
                startCount.await();
                System.out.println("线程：" + name + "开始");
                System.out.println("线程："+name+"开始do something");
                int rand = new Random().nextInt(20);
                Thread.sleep(rand*1000);
                System.out.println("线程："+name+"is over");
                endCount.countDown();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
