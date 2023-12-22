package com.gzy.algo.month202312;

import java.util.concurrent.*;

public class RunnableInnerSubmitToThreadPoolTest {

    final static ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(5);
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        myRunnable.run();
    }


    public static  class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executor.execute(this);
        }
    }
}
