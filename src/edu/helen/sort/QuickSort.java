package edu.helen.sort;

import java.util.Arrays;

public class QuickSort {

	public QuickSort() {
	}

	public void quickSort(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}
		sort(num, 0, num.length - 1);
	}

	private void sort(int[] num, int low, int high) {
		int i = low;
		int j = high;
		int pivot = num[low + (high - low) / 2];
		while (i <= j) {
			while (num[i] < pivot) {
				i++;
			}
			while (num[j] > pivot) {
				j--;
			}
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				i++;
				j--;
			}
		}
		if (j > low) {
			sort(num, low, j);
		}
		if (i < high) {
			sort(num, i, high);
		}
	}

//	public static void main(String[] args) {
////		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
////				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
//		int a [] = {3,4,2,5,1};
//		QuickSort sort = new QuickSort();
//		sort.quickSort(a);
//		String str = Arrays.toString(a);
//		System.out.println(str);
//	}

	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
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
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
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
