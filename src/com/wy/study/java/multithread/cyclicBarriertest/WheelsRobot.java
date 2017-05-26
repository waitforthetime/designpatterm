package com.wy.study.java.multithread.cyclicBarriertest;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class WheelsRobot extends Robot {

    public WheelsRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing wheels");
        assembler.getCar().addWheels();
    }
}
