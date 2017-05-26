package com.wy.study.java.multithread.cyclicBarriertest;

/**
 * Created by wy_ms on 2017/05/20.
 */
public class Car {

    private final int id;

    private boolean engine = false, driveTrain = false, wheels = false;

    public Car(int id) {
        this.id = id;
    }

    public Car() {
        id = -1;
    }

    public int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    public synchronized String toString() {
        return "Car " + id + " [ engine：" + engine + " driveTrain："+ driveTrain + " wheels：" + wheels + "]";
    }
}
