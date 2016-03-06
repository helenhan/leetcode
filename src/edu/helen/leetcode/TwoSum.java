package edu.helen.leetcode;

public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = null;
		if(nums==null||nums.length==0){
			return result;
		}
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if((nums[i]+nums[j])==target){
					result = new int[]{i,j};
				}
			}
		}
		
		return result;

	}

}
