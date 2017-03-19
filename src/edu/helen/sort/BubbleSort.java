package edu.helen.sort;

import java.util.Arrays;

/**
 * Created by Helen on 1/10/2017.
 */
public class BubbleSort {

    public void sort(int[] a){
        int temp  = 0;
        for(int i =0;i<a.length-1;i++){
            for(int j=0;i<a.length-i-1;j++){
                if(a[j]>a[j+1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
                99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
        sort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
