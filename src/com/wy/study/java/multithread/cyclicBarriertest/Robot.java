package com.wy.study.java.multithread.cyclicBarriertest;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by wy_ms on 2017/05/20.
 */
public abstract class Robot implements Runnable {

    protected Assembler assembler;
    protected boolean engine;
    protected final RobotPool pool;

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }

    public synchronized void engine() {
        engine = true;
        notifyAll();
    }

    @Override
    public void run() {

        try {
            perdown();
            while (!Thread.interrupted()) {
                performService();
                assembler.getBarrier().await();
                perdown();
            }
        } catch (InterruptedException e) {
            System.out.println("robot interrupted");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("robot is over");
    }

    abstract protected void performService();

    private synchronized void perdown() throws InterruptedException {
        assembler = null;
        engine = false;
        pool.release(this);
        while (!engine) {
            System.out.println(this+"进入睡眠");
            wait();
            System.out.println(this+"被唤醒");
        }
    }

    public String toString() {
        return this.getClass().getName();
    }
}
