package com.hand.ysl.sortdemo;

/**
 * Created by Ernst on 2018/2/28.
 */
public class InsertSortDemo {
    public static void insertSort(int[] data){
        int i,j,insertNode;
        for(i=1;i<data.length;i++){
            insertNode = data[i];
            j=i-1;
            while(j>0 && data[j]>insertNode){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = insertNode;
        }
    }

    public static void main(String[] args) {
        int a[] = {1,5,4,5,3,5,32,67,4,3};
        InsertSortDemo.insertSort(a);
        for(int s:a){
            System.out.println(s);
        }
    }

}
