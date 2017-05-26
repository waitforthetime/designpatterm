package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class TestDemo {

    public static void main(String[] args) {
        BlockingQueue<Car> chassisQueue = new LinkedBlockingDeque<>();
        BlockingQueue<Car> finshingQueue = new LinkedBlockingDeque<>();
        RobotPool pool = new RobotPool();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new EnginRobot(pool));
        exec.execute(new DriveTrainRobot(pool));
        exec.execute(new WheelsRobot(pool));
        exec.execute(new Assembler(pool,chassisQueue,finshingQueue));
        exec.execute(new ChassisBuilder(chassisQueue));
        exec.execute(new Reported(finshingQueue));
    }

}
