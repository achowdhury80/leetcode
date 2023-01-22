package com.prep2020.medium;

public class Problem331 {
	/**
	 * O(N)
	 * @param preorder
	 * @return
	 */
	public boolean isValidSerialization(String preorder) {
		int[] index = new int[1];
		String[] arr = preorder.split(",");
        return helper(arr, index) && index[0] == arr.length;
    }
	
	private boolean helper(String[] arr, int[] index) {
		if (index[0] >= arr.length) return false;
		if (arr[index[0]].equals("#")) {
			index[0]++;
			return true;
		}
		index[0]++;
		return helper(arr, index) && helper(arr, index);
	}
}
