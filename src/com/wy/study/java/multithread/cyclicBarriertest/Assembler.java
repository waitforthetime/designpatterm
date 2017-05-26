package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class Assembler implements Runnable {

    private final RobotPool pool;
    private final CyclicBarrier barrier;
    private final BlockingQueue<Car> chassisQueue;
    private final BlockingQueue<Car> finshingQueue;
    private Car car;

    public Assembler(RobotPool pool, BlockingQueue<Car> chassisQueue, BlockingQueue<Car> finshingQueue) {
        this.pool = pool;
        this.chassisQueue = chassisQueue;
        this.finshingQueue = finshingQueue;
        barrier = new CyclicBarrier(4);
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                pool.hire(EnginRobot.class, this);
                pool.hire(DriveTrainRobot.class, this);
                pool.hire(WheelsRobot.class,this);
                barrier.await();
                finshingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Assembier interrupted");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Assembier off");
        }
    }
}
