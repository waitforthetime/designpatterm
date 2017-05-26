package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.concurrent.BlockingQueue;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class Reported implements Runnable {

    private final BlockingQueue<Car> finshingQueue;

    public Reported(BlockingQueue<Car> finshingQueue) {
        this.finshingQueue = finshingQueue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                Car car = finshingQueue.take();
                System.out.println(car);
            }
        } catch (InterruptedException e) {
            System.out.println("reported interrupted");
        }

    }
}
