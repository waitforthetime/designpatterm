package com.wy.study.java.multithread.objectinit;

/**
 * Created by wy_ms on 2017/05/24.
 */
public class Father {

    private Father father;
    private Sun sun;

    public Father() {
    }

    public Father(Father father, Sun sun) {
        this.father = father;
        this.sun = sun;
    }

    public static void main(String[] args) {
        Sun sun = new Sun();
        sun.pri();
        Father father = new Father(sun,sun);
        father.pri();
        father.primember();
    }

    private void pri() {
        System.out.println("father private");
    }

    public void primember() {
        father.pri();
        sun.pri();
    }



}
