package com.hand.ysl.queuedemo;

/**
 * Created by Ernst on 2018/2/27.
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        System.out.println(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }
        System.out.println(queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

    class ArrayQueue{
        private int[] arrInt;//内置数组
        private int front;//头指针
        private int reer;//尾指针

        public ArrayQueue(int size){
            this.arrInt = new int[size];
            front=0;
            reer=-1;
        }

        /*
        判断队列是否为空
         */
        public boolean isEmpty(){
            return front==arrInt.length;
        }

        /*
        判断队列是否已满
         */
        public boolean isFull(){
            return arrInt.length-1==reer;
        }

        /*
        向队列的队尾插入一个元素
         */
        public void insert(int item){
            if(isFull()){
                throw new RuntimeException("队列已满");
            }
            arrInt[++reer]=item;
        }

        /*
        获得队头元素
         */
        public int peekFront(){
            return arrInt[front];
        }

        /*
        获得队尾元素
         */
        public int peekReer(){
            return arrInt[reer];
        }

        /*
        从队列的队头移除一个元素
         */
        public int remove(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            //返回队头元素并将头指针加1
            return arrInt[front++];
        }
    }

