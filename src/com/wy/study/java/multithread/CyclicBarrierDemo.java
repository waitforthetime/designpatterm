package com.wy.study.java.multithread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wy_ms on 2017/05/13.
 */
public class CyclicBarrierDemo {

    static class Runner implements Runnable {

        private final CyclicBarrier barrier;
        private final int times;
        private int pre = 0;

        public Runner(CyclicBarrier barrier, int times) {
            this.barrier = barrier;
            this.times = times;
        }

        @Override
        public void run() {
            while (pre++<times) {
                boolean issuccess = false;
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println("选手" + name + "开始第"+pre+"轮run");
                    int index = new Random().nextInt(10);
                    Thread.sleep(index * 1000);
                    System.out.println("选手" + name + "第"+pre+"轮跑到终点了");
                    if ("Thread-4".equals(name)&&2==pre) {
                        throw new Exception("老子不跑了");
                    }
                    barrier.await();
                    issuccess = true;
                } catch (Throwable e) {
                    System.out.println(Thread.currentThread().getName()+"第"+pre+"异常了");
                } finally {
                    if (!issuccess) {
                        try {barrier.await();}catch (Throwable e) {}
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int nums = 10;
        int times = 3;
        CyclicBarrier barrier = new CyclicBarrier(nums);
        for (int i = 0; i < nums; i++) {
            new Thread(new Runner(barrier,times)).start();
        }


    }


}
