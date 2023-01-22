package com.prep2020.medium;

public class Problem255 {
	/**
	 * O(N)
	 * @param preorder
	 * @return
	 */
	public boolean verifyPreorder(int[] preorder) {
        return validate(preorder, 0, preorder.length - 1, 1, 10000);
    }
	
	private boolean validate(int[] arr, int start, int end, int min, int max) {
		if (min > max) return false;
		if (arr[start] < min || arr[start] > max) return false;
		if (start == end) return true;
		int rightSubTreeIndex = findBiggerNumberIndex(arr, start + 1, end, 
				arr[start]);
		if (rightSubTreeIndex == -1) return validate(arr, start + 1, end, min, 
				arr[start] - 1);
		if (rightSubTreeIndex > start + 1 && !validate(arr, start + 1, 
				rightSubTreeIndex - 1, min, arr[start] - 1)) return false;
		if (rightSubTreeIndex > -1 && !validate(arr, rightSubTreeIndex, 
				end, arr[start] + 1, max)) return false;
		return true;
	}
	
	private int findBiggerNumberIndex(int[] arr, int start, int end, int root) {
		for (int i = start; i <= end; i++) {
			if (arr[i] > root) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Problem255 problem = new Problem255();
		System.out.println(problem.verifyPreorder(new int[] {5, 2, 6, 1, 3}));
	}
}
