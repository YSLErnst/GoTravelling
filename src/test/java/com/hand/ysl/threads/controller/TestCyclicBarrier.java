package com.hand.ysl.threads.controller;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Ernst on 2017/12/27.
 * CyclicBarrier栅栏，等待线程数到了指定数量后，所有进入等待的线程被唤醒并继续执行。
 *
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 */
public class TestCyclicBarrier {
    private static final int threadNum = 5;

    public static class WorkThread implements Runnable{
        CyclicBarrier barrier;

        WorkThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try{
                System.out.println("worker is waiting");
                barrier.await();
                System.out.println("thread "+Thread.currentThread().getId()+" is working;");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("inside the barrier");
            }
        });

        for(int i=0;i<threadNum;i++){
            new Thread(new WorkThread(cb)).start();
        }

        System.out.println("cyclicBarrier重用");
        for(int i=0;i<threadNum;i++){
            new Thread(new WorkThread(cb)).start();
        }
    }
}
