package edu.helen.sort;

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
		int[] helper = new int[high];
		for (int i = low; i < high; i++) {
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
			num[k] = num[i];
			i++;
			k++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
