package com.hand.ysl.threads.controller;

import java.util.concurrent.Semaphore;

/**
 * Created by Ernst on 2017/12/27.
 * 指定同一时间允许多少个线程一起运行，acquire获取资源，release释放资源。
 *
 * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用。
 * 那么我们就可以通过Semaphore来实现：
 */
public class TestSemaphore {
    public static void main(String[] args) {
        int workerNum = 8;//工人数
        Semaphore semaphore = new Semaphore(5);//机器数

        for(int i=0;i<workerNum;i++){
            new Thread(new WorkerThread(semaphore,i)).start();
        }
    }

    static class WorkerThread implements Runnable{

        private Semaphore semaphore;
        private int num;

        WorkerThread(Semaphore semaphore,int num){
            this.semaphore = semaphore;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker " + num + " is running");
                Thread.sleep(3000);
                System.out.println("worker "+num +" release resources");
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
