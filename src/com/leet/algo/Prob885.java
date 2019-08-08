package com.leet.algo;

public class Prob885 {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int elemCount = R * C;
        int[][] result = new int[elemCount][];
        int i = 0;
        int[] cur = new int[] {r0, c0};
        result[i++] = cur;
        int[][] dir = new int[][]{{0, 1}, {1, 0},{0, -1},{-1, 0}};
        int d = 0;
        int move = 1;
        int k = 0;
        while(i < elemCount) {
        	
        	for (int j = 0; j < move; j++) {
        		cur = new int[] {cur[0] + dir[d][0], cur[1] + dir[d][1]};
        		if (cur[0] > -1 && cur[0] < R && cur[1] > -1 && cur[1] < C) {
        			result[i++] = cur;
        		}
        	
        	}
        	d = (d + 1) % 4;
        	k++;
        	if (k % 2 == 0) {
        		move++;
        		k %= 2;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob885 prob = new Prob885();
		int[][] arr = prob.spiralMatrixIII(1, 4, 0, 0);
		System.out.println(arr);
	}
}
