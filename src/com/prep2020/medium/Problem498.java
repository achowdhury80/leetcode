package com.prep2020.medium;

public class Problem498 {
	/**
	 * O(m * n)
	 * @param mat
	 * @return
	 */
	public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        boolean up = true;
        result[0] = mat[0][0];
        int[] cur = new int[] {0, 0};
        for (int i = 1; i < m * n; i++) {
        	int[] next = cur;
        	if (up) {
        		if (next[0] == 0 || next[1] > n - 2) {
        			if (next[1] == n - 1) next[0]++;
        			else next[1]++;
        			up = !up;
        		} else {
        			next[0]--;
        			next[1]++;
        		}
        	} else {
        		if (next[0] == m - 1 || next[1] == 0) {
        			if (next[0] == m - 1) next[1]++;
        			else next[0]++;
        			up = !up;
        		} else {
        			next[0]++;
        			next[1]--;
        		}
        	}
        	result[i] = mat[next[0]][next[1]];
        	cur = next;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem498 problem = new Problem498();
		int[] result = problem.findDiagonalOrder(new int[][] {{1, 2}, {3, 4}});
		System.out.println(result);
	}
}
