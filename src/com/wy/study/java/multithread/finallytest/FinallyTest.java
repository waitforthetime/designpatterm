package com.wy.study.java.multithread.finallytest;

/**
 * Created by wy_ms on 2017/05/26.
 */
public class FinallyTest {

    class FinaException extends Exception {
        public String toString() {
            return "there is finaException";
        }
    }

    class TryException extends Exception {
        public String toString() {
            return "there is tryException";
        }
    }

    void f() throws TryException {
        throw new TryException();
    }

    void g() throws FinaException {
        throw new FinaException();
    }

    public static void main(String[] args) {

        FinallyTest ft = new FinallyTest();
        try {
            try {
                ft.f();//this exception is lost
            } catch (Exception e) {
                throw e;//through the exception has catched and throw to the above , but it is still lost
            } finally {
                ft.g();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
