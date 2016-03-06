package edu.helen.sort;

public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
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
			if (num[i] < pivot) {
				i++;
			}
			if (num[j] > pivot) {
				j--;
			}
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

	public static void main(String[] args) {
	}

}
