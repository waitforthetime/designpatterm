package com.wy.study.java.multithread.waitandnotify;

/**
 * Created by wy_ms on 2017/05/19.
 */
public class WaitAndNotifyDemo {

    static class Runner implements Runnable {

        private final Object lock;

        public Runner(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"拿到锁，进入睡眠");
                    Thread.sleep(1000);
                    System.out.println(name+"睡眠结束");
                    System.out.println(name+"开始进入等待");
                    lock.wait();
                    System.out.println(name+"被唤醒了");
//                    System.out.println(name+"再睡会");
//                    Thread.sleep(1000);
//                    System.out.println(name+"睡醒了，结束了");
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runner(lock)).start();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        synchronized (lock) {
            System.out.println(name+"拿到锁");
            System.out.println(name+"准备唤醒所有等待");
            lock.notifyAll();
            System.out.println(name+"只是唤醒，但是仍然占有锁");
            System.out.println(name+"进入睡眠");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"睡眠结束");
            System.out.println(name+"创建多个线程枪锁");
            for (int i = 0; i < 100; i++) {
                new Thread(new Runner(lock)).start();
            }
        }
       /* System.out.println(name+"重新拿锁之前，我再睡会");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"睡醒了，等待重新获取锁");
        synchronized (lock) {
            System.out.println(name+"重新拿到锁了,我也睡会");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"睡醒了，结束了");
        }*/
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }




}
