package edu.helen.leetcode;

public class ValidPreoderSerialTree {

	public ValidPreoderSerialTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * for a binary tree : count_null=count_node+1 we just need to find the
	 * shortest prefix of the serialization sequence satisfying the property
	 * above. If such prefix does not exist, then the serialization is
	 * definitely invalid; otherwise, the serialization is valid if and only if
	 * the prefix is the entire sequence.
	 **/
	public boolean isValidSerialization(String preorder) {
		int count_null = 0;
		int count_leaf = 0;
		String[] strs = preorder.split(",");
		int i = 0;
		for (i = 0; i < strs.length && count_null != count_leaf + 1; i++) {
			if (strs[i].equals("#") ) {
				count_null++;
			} else {
				count_leaf++;
			}
		}
		return (i == strs.length) && (count_null == count_leaf + 1);
	}
	
	public static void main(String[] args){
		ValidPreoderSerialTree vpst = new ValidPreoderSerialTree();
		boolean result = vpst.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
		System.out.print(result);
	}
	
	
}
