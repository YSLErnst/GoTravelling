package com.hand.ysl.sortdemo;

/**
 * Created by Ernst on 2018/2/28.
 */
public class BubbleSortDemo {
    public static void bubbleSort(int[] data){
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<data.length-1-i;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1,5,4,5,3,5,32,67,4,3};
        BubbleSortDemo.bubbleSort(a);
        for(int s:a){
            System.out.println(s);
        }
    }
}
