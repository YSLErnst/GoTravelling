package com.hand.ysl.queuedemo;

/**
 * Created by Ernst on 2018/2/27.
 */
public class LinkedListQueueDemo {

}

class QueueNode{
    Object data;
    QueueNode next;

    public QueueNode(){
        this(null,null);
    }

    public QueueNode(Object data){
        this(data,null);
    }

    public QueueNode(Object data,QueueNode next){
       this.data = data;
        this.next = next;
    }

}

/*
单向链表实现的队列
 */
class QueueLinked{
    QueueNode front;//队首指针
    QueueNode reer;//队尾指针
    public QueueLinked(){
       this.front = null;
        this.reer = null;
    }
    /*
    将一个对象追加到队列的尾部
     */
    public void enqueue(Object obj){
       //如果队列是空的
        if(reer == null && front ==null){
            //队尾就是新添加的，队首就是队尾
            reer = new QueueNode(obj,null);
            front = reer;
        }else{
            QueueNode node = new QueueNode(obj);
            reer.next = node;
            reer = reer.next;
        }
    }

    /*
    队首对象出队
    出队的对象，如果队列为空 返回null
     */
    public Object dequeue(){
        if(front==null){
            return null;
        }
        //如果队列中只剩下一个对象
        if(front==reer && reer!=null){
            QueueNode node = front;
            front = null;
            reer = null;
            return node.data;
        }
        Object obj = front.data;
        front = front.next;
        return obj;
    }

    public static void main(String[] args) {
        QueueLinked q = new QueueLinked();
        q.enqueue("张三");
        q.enqueue("李斯");
        q.enqueue("赵五");
        q.enqueue("王一");
        for (int i = 0; i < 4; i++) {
            System.out.println(q.dequeue());
        }
    }
}
