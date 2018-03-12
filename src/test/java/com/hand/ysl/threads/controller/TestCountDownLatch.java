package com.hand.ysl.threads.controller;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Ernst on 2017/12/27.
 *等待指定数量的线程执行完毕后(countDown的计数器为0后),开始执行之后的代码
 *
 * 　1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：

 　　　　CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；

 　　　　而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；

 　　　　另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。

 　　2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 */
public class TestCountDownLatch {
    private static final CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(){
                public void run(){
                    try{
                        System.out.println("thread "+Thread.currentThread().getId()+" is running;");
                        Thread.sleep(3000);
                        System.out.println("thread "+Thread.currentThread().getId()+" runs over;");
                        latch.countDown();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }.start();
        }

        try{
            System.out.println("等待俩个线程运行完毕");
            latch.await();
            System.out.println("俩个线程运行完毕，开始运行主线程");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
