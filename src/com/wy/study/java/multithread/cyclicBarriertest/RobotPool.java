package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class RobotPool {
    private final Set<Robot> robots = new HashSet<>();

    public synchronized void add(Robot robot) {
        robots.add(robot);
        notifyAll();
    }

    public synchronized void release(Robot robot) {
        add(robot);
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler assembler) throws InterruptedException {

        for (Robot robot: robots) {
            System.out.println("hire："+robot);
            if (robot.getClass().equals(robotType)) {
                robots.remove(robot);
                robot.setAssembler(assembler);
                robot.engine();
                return;
            }
        }
        wait();
        hire(robotType,assembler);
    }

}
