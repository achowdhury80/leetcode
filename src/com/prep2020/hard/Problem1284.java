package com.prep2020.hard;
import java.util.*;
public class Problem1284 {
	public int minFlips(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		boolean[] visited = new boolean[(1 << (m * n))];
		Queue<int[][]> q = new LinkedList<>();
		int encodedVal = encode(mat);
		if (encodedVal == 0) return 0;
		q.offer(mat);
		visited[encodedVal] = true;
		int result = 0;
		while(!q.isEmpty()) {
			result++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[][] cur = q.poll();
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < n; k++) {
						int[][] newMat = flip(cur, new int[] {j, k});
						encodedVal = encode(newMat);
						if (encodedVal == 0) return result;
						if (visited[encodedVal]) continue;
						visited[encodedVal] = true;
						q.offer(newMat);
					}
				}
			}
		}
		return -1;
    }
	
	private int[][] flip(int[][] mat, int[] pos) {
		int m = mat.length, n = mat[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = mat[i][j];
			}
		}
		result[pos[0]][pos[1]] ^= 1;
		if (pos[0] - 1 > -1) result[pos[0] - 1][pos[1]] ^= 1;
		if (pos[0] + 1 < m) result[pos[0] + 1][pos[1]] ^= 1;
		if (pos[1] - 1 > -1) result[pos[0]][pos[1] - 1] ^= 1;
		if (pos[1] + 1 < n) result[pos[0]][pos[1] + 1] ^= 1;
		return result;
	}

	private int encode(int[][] mat) {
		int result = 0, m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					int idx = i * n + j;
					result |= (1 << idx);
				}
			}
		}
		return result;
	}
}
