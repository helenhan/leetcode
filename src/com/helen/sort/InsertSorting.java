package com.helen.sort;

import java.util.Arrays;

public class InsertSorting {

	public InsertSorting() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(int[] array){
		if(array==null||array.length==0){
			return;
		}
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<i;j++){
				if(array[i]<array[j]){
					
					array[j+1]=array[j];
				}
			}
		}
	}

	public void insertSort(int[] a){

	}

	public static void main(String[] args) {
		InsertSorting is = new InsertSorting();
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		is.sort(a);
		System.out.println(Arrays.toString(a));
	}

}
