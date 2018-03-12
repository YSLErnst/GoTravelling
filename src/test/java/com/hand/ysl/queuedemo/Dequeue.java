package com.hand.ysl.queuedemo;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ernst on 2018/2/27.
 * java双向链表实现双端队列
 */
public class Dequeue<Object> implements Iterable<Object> {
    private Node first;
    private Node last;
    private int N;

    public Dequeue(){

    }
    private class Node{
        private Node pre;
        private Node next;
        private Object value;
    }
    private int size(){
        return N;
    }
    private boolean isEmpty(){
        return N==0;
    }

    public void pushLeft(Object value){
        if(isEmpty()){
            first = new Node();
            first.value = value;
            last = first;
        }else {
            Node oldFirst = first;
            first = new Node();
            first.value = value;
            first.next = oldFirst;
            oldFirst.pre = first;
        }
        N++;
    }

    public void pushRight(Object value){
        if(isEmpty()){
            last = new Node();
            last.value = value;
            first = last;
        }else{
            Node oldLast = last;
            last = new Node();
            last.value = value;
            last.pre = oldLast;
            oldLast.next = last;
        }
        N++;
    }

    public Object popLeft() throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        Object value = first.value;
        first = first.next;
        if(N==1){
            first = null;
            last = null;
        }else {
            first.pre = null;
        }
        N--;
        return value;
    }

    public Object popRight() throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空");
        }
        Object value = last.value;
        last = last.pre;
        if(N==1){
           last = null;
            first = null;
        }else {
            last.next = null;
        }
        N--;
        return value;
    }

    public void print(){
        Node current = first;
        while(current!=null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println();
    }

    //迭代
    public Iterator<Object> iterator(){
        return new Iterator<Object>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Object next() {
                Object value = current.value;
                current = current.next;
                return value;
            }

            @Override
            public void remove() {

            }
        };
    }

    //反向迭代
    public Iterable<Object> reverseIterator(){
        return new Iterable<Object>() {
            @Override
            public Iterator<Object> iterator() {
                return new Iterator() {
                    Node current = last;
                    @Override
                    public boolean hasNext() {
                        return current!=null;
                    }

                    @Override
                    public Object next() {
                        Object value = current.value;
                        current = current.pre;
                        return value;
                    }

                    @Override
                    public void remove() {

                    }
                };
            }
        };

    }




    public static void main(String[] args) throws Exception{
        Dequeue<String> q=new Dequeue<String>();

        q.pushLeft("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushRight("c");
        q.pushRight("b");
        q.pushRight("a");
        System.out.println("左出");
        q.print();//c  b  a  c  b  a

        q.popLeft();
        q.print();//b  a  c  b  a
        q.popLeft();
        q.print();//a  c  b  a
        q.popLeft();
        q.print();//c  b  a
        q.popLeft();
        q.print();//b  a
        q.popLeft();
        q.print();//a
        q.popLeft();
        q.print();//空
        //在来一遍

        q.pushLeft("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushRight("c");
        q.pushRight("b");
        q.pushRight("a");
        System.out.println("右出");
        q.print();//c  b  a  c  b  a

        q.popRight();
        q.print();//c  b  a  c  b
        q.popRight();
        q.print();//c  b  a  c
        q.popRight();
        q.print();//c  b  a
        q.popRight();
        q.print();//c  b
        q.popRight();
        q.print();//c
        q.popRight();
        q.print();


        System.out.println("---------------");
        q.pushLeft("a");
        q.pushLeft("b");
        q.pushLeft("c");
        q.pushLeft("d");
        q.pushLeft("e");
        q.pushLeft("f");


        System.out.println("正向排序");

        for(String a:q){
            System.out.print(a+"  ");
        }
        System.out.println();
        System.out.println("反向排序");
        for(String a:q.reverseIterator()){
            System.out.print(a+"  ");
        }
        Map m = new HashMap();
    }
}
