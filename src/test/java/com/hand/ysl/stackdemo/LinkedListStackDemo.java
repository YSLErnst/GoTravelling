package com.hand.ysl.stackdemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ernst on 2018/2/27.
 * 使用Node辅助类实现链式栈
 */
public class LinkedListStackDemo<T> {

    private class Node{
        T data;
        Node next;

        public Node(T data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    /*
    保存元素个数
     */
    private int theSize;

    /*
    保存栈顶元素
     */
    private Node top;

    public LinkedListStackDemo(T value){
        top = new Node(value,null);
    }

    /*
    压栈
     */
    public void push(T value){
        top = new Node(value,top);
        theSize++;
    }

    /*
    出栈
     */
    public T pop(){
        Node old = top;
        top = top.next;
        old.next = null;
        theSize--;
        return old.data;
    }

    /*
    拿到栈顶元素
     */
    public T peek(){
        return top.data;
    }

    /*
    拿到元素个数
     */
    public int size(){
        return theSize;
    }

    /*
    判断是否为空
     */
    public boolean isEmpty(){
        return size()==0;
    }

}
