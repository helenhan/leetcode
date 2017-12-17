package edu.helen.sort;

import java.util.Arrays;

/**
 * quick VS merge
 * <p>
 * time                                        space                稳定性                其它
 * <p>
 * quick   O(nlogn)平均,慢会O(n^2)          O(1)                 不稳定             先整体后局部
 * <p>
 * merge    一直O(nlogn)                             O(n)                  稳定               先局部后整体
 * <p>
 * merge sort因为要重新开一个数组，开空间再删空间这个操作影响了速度， 所以quick sort是比merge sort快的
 */
public class QuickSort {
    public void quickSort(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        quickSort(num, 0, num.length - 1);
    }

    public static void main(String[] args) {
        int[] x = {9, 2, 4, 7, 3, 7, 10};
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println(Arrays.toString(x));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        // key point 1: pivot is the value, not the index
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (i <= j) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

}
