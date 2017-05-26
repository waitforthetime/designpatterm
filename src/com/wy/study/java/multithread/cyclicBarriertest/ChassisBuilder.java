package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.concurrent.BlockingQueue;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class ChassisBuilder implements Runnable {

    private final BlockingQueue<Car> chassisQueue;

    private int count;

    public ChassisBuilder(BlockingQueue<Car> chassisQueue) {
        this.chassisQueue = chassisQueue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "开始生产Car");
                Car car = new Car(count++);
                chassisQueue.put(car);
                Thread.sleep(1000);//1秒产生一个
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted：chassisBuilder");
        }
        System.out.println("发生异常，结束生产");
    }
}
