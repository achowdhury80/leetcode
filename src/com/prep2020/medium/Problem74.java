package com.prep2020.medium;

public class Problem74 {
	/**
	 * O(mnlog(mn))
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	int[] pos = new int[] {mid / n, mid % n};
        	if (matrix[pos[0]][pos[1]] == target) return true;
        	if (matrix[pos[0]][pos[1]] > target) high = mid - 1;
        	else low = mid + 1;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Problem74 problem = new Problem74();
		System.out.println(problem.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
	}
}
