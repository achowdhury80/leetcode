package com.prep2020.medium.more2000;

public class Problem2120 {
	public int[] executeInstructions(int n, int[] startPos, String s) {
		int m = s.length();
		int[] result = new int[m];
		int[][] dirs = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		for (int i = 0; i < m; i++) {
			int[] cur = new int[] {startPos[0], startPos[1]};
			int count = 0;
			for (int j = i; j < m; j++) {
				int idx = "LRUD".indexOf(s.charAt(j));
				cur = new int[] {cur[0] + dirs[idx][0], cur[1] + dirs[idx][1]};
				if (cur[0] < 0 || cur[0] == n || cur[1] < 0 || cur[1] == n)
					break;
				count++;
			}
			result[i] = count;
		}
		return result;
	}
}
