package com.hand.ysl.sortdemo;

/**
 * Created by Ernst on 2018/2/28.
 */
public class SelectSortDemo {
    public static void selectSort(int[] data){
        for(int i=0;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i]>data[j]){
                    swap(data,i,j);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int a[] = {1,5,4,5,3,5,32,67,4,3};
        SelectSortDemo.selectSort(a);
        for(int s:a){
            System.out.println(s);
        }
    }
}
