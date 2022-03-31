package com.helen.sort;

import java.util.Arrays;

public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	public void mergeSort(int[] num, int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(num, low, middle);
			mergeSort(num, middle + 1, high);
			merge(num, low, middle, high);
		}
	}

	private void merge(int[] num, int low, int middle, int high) {
		int[] helper = new int[num.length];
		for (int i = low; i <= high; i++) {
			helper[i] = num[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				num[k] = helper[i];
				i++;
			} else {
				num[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			num[k] = helper[i];
			i++;
			k++;
		}
	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		MergeSort sort = new MergeSort();
		sort.mergeSort2(a, 0, a.length - 1);
		String str = Arrays.toString(a);
		System.out.println(str);
	}

	public void mergeSort2(int[] num, int low, int high) {
		if(low<high){
			int mid = low + (high-low)/2;
			mergeSort2(num,low,mid);
			mergeSort2(num,mid+1,high);
			merge2(num,low,mid,high);
		}
	}

	private void merge2(int[] nums,int low, int mid, int high){
		int[] help = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			help[i] = nums[i];
		}
		int left =low;
		int right = mid+1;
		int k = low;
		while(left<=mid&&right<=high){
			if(help[left]<=help[right]){
				nums[k++] = help[left++];
			}else{
				nums[k++] = help[right++];
			}
		}
		while(left<=mid){
			nums[k++] = help[left++];
		}
		while(right<=high){
			nums[k++] = help[right++];
		}

	}

}
