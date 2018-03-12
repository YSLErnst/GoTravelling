package com.hand.ysl.stackdemo;

/**
 * Created by Ernst on 2018/2/27.
 * 使用数组实现栈
 */
public class ArrayStackDemo<T> {

    private T[] dataArr;

    private int theSize;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStackDemo(){
        clear();
    }

    private void clear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);

    }

    /*
    栈元素容量
     */
    public int size(){
        return theSize;
    }

    private void ensureCapacity(int newCapacity){
        if(newCapacity<theSize){
            return;
        }
        T[] oldArr = dataArr;
        dataArr = (T[])new Object[newCapacity];
        for(int i=0;i<size();i++){
            dataArr[i]=oldArr[i];
        }
    }

    /*
    入栈
     */
    public void push(T value){
        if(dataArr.length==size()){
            ensureCapacity(size()*2);
        }
        dataArr[theSize++]=value;
    }

    /*
    栈是否为空
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /*
    出栈
     */
    public T pop(){
        if(isEmpty()){
           return null;
        }
        T theValue = dataArr[theSize-1];
        dataArr[--theSize]=null;
        return theValue;
    }

    /*
    返回栈尾元素
     */
    public T peek(){
        if(isEmpty()){
            return null;
        }
        T theValue = dataArr[theSize-1];
        return theValue;
    }

}
