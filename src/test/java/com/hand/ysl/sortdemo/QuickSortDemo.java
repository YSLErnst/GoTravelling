package com.hand.ysl.sortdemo;

/**
 * Created by Ernst on 2018/3/2.
 */
public class QuickSortDemo {

    public static int partition(int array[], int low, int high) {
        //当前位置为第一个元素所在位置
        int p_pos = low;
        //采用第一个元素为轴
        int pivot = array[p_pos];

        for (int i = low + 1; i <= high; i++) {


            if (array[i] < pivot) {

                p_pos++;


                swap(array, p_pos, i);


            }


        }


        swap(array, low, p_pos);


        return p_pos;


    }

    public static void swap(int a[], int i, int j) {

        if(i == j) return;


        int tmp = a[i];


        a[i] = a[j];


        a[j] = tmp;


    }

    public static void main(String[] args) {
        int [] a = {45,36,18,53,72,30,48,93,15,36};
        partition(a,0,a.length-1);
        for(int s:a){
            System.out.print(s+" ");
        }
    }

}
