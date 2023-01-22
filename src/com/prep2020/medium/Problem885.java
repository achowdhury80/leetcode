package com.prep2020.medium;

public class Problem885 {
	/**
	 * Time Complexity: O((\max(R, C))^2)O((max(R,C)) 
2
 ). Potentially, our walk needs to spiral until we move RR in one direction, and CC in another direction, so as to reach every cell of the grid.

Space Complexity: O(R * C)O(R∗C), the space used by the answer.

	 * @param R
	 * @param C
	 * @param r0
	 * @param c0
	 * @return
	 */
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int n = R * C;
        int[][] result = new int[n][];
        result[0] = new int[] {r0, c0};
        int idx = 1;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int move = 1;
        int[] cur = new int[] {r0, c0};
        while(idx < n) {
        	for (int i = 0; i < move; i++) {
        		cur = new int[] {cur[0] + dirs[dirIndex][0], cur[1] + dirs[dirIndex][1]};
        		if (isValidPos(R, C, cur)) result[idx++] = cur;
        	}
        	dirIndex = (dirIndex + 1) % 4;
        	for (int i = 0; i < move; i++) {
        		cur = new int[] {cur[0] + dirs[dirIndex][0], cur[1] + dirs[dirIndex][1]};
        		if (isValidPos(R, C, cur)) result[idx++] = cur;
        	}
        	dirIndex = (dirIndex + 1) % 4;
        	move++;
        }
        return result;
    }
	
	private boolean isValidPos(int R, int C, int[] cur) {
		return cur[0] > -1 && cur[0] < R && cur[1] > -1 && cur[1] < C;
	}
	
	public static void main(String[] args) {
		Problem885 prob = new Problem885();
		System.out.println(prob.spiralMatrixIII(1, 4, 0, 0));
	}
}
