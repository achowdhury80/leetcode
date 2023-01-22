package com.prep2020.medium;

public class Problem1901 {
	/**
	 * O(mlog(N) /nlog(m))
	 * @param mat
	 * @return
	 */
	public int[] findPeakGrid(int[][] mat) {
        int[] result = new int[2];
        int m = mat.length, n = mat[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean found = false;
        while(!found) {
        	found = true;
        	for (int[] dir : dirs) {
        		int[] next = new int[] {result[0] + dir[0], result[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n)
        			continue;
        		if (mat[result[0]][result[1]] < mat[next[0]][next[1]]) {
        			result = next;
        			found = false;
        		}
        	}
        }
        return result;
    }
}
