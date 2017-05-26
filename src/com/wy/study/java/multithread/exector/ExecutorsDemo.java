package com.wy.study.java.multithread.exector;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wy_ms on 2017/05/18.
 */
public class ExecutorsDemo {



    static class Runner implements Runnable {

        @Override
        public void run() {
           /* for (int i = 0; i < 1823870; i++) {
                System.out.println(i);
            }*/
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testInterrupt() {
        Runner run = new Runner();
        Thread t = new Thread(run);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("中断结束");
    }

    public static void main(String[] args) {

        /*ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.submit(new Runner());
        exec.shutdown();*/
        ThreadPoolExecutor exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                20000L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>());
        /*ThreadPoolExecutor exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                2000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());*/

//        ThreadPoolExecutor exec = new ThreadPoolExecutor(5, 5,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            exec.submit(new Runner());
            System.out.println("pool size："+ exec.getPoolSize() + "\tqueue size：" + exec.getQueue().size());
        }
//        exec.shutdown();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("pool size："+ exec.getPoolSize() + "\tqueue size：" + exec.getQueue().size());
            System.out.println("pool state：" + exec.isShutdown());
        }
        for (int i = 0; i < 20; i++) {
            exec.submit(new Runner());
            System.out.println("pool size："+ exec.getPoolSize() + "\tqueue size：" + exec.getQueue().size());
        }
    }


}
