package com.prep2020.hard;
import java.util.*;
public class Problem1444 {
	public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][][] appleCount = new int[m][n][2];
        for (int i = 0; i < m; i++) appleCount[i][n - 1][0] = pizza[i].charAt(n - 1) == 'A' ? 1 : 0;
        for (int i = 0; i < n; i++) appleCount[m - 1][i][1] = pizza[m - 1].charAt(i) == 'A' ? 1 : 0;
        for (int i = 0; i < m; i++) {
        	for (int j = n - 2; j > -1; j--) {
        		appleCount[i][j][0] = appleCount[i][j + 1][0] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
        	}
        }
        for (int j = 0; j < n; j++) {
        	for (int i = m - 2; i > -1; i--) {
        		appleCount[i][j][1] = appleCount[i + 1][j][1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
        	}
        }
        int totalApple = 0;
        for (int i = 0; i < m; i++) totalApple += appleCount[i][0][0];
        return (int)helper(new int[] {0, 0}, k, appleCount, totalApple, new HashMap<>());
    }
	
	private long helper(int[] start, int pieces, int[][][] appleCount, int totalApple, 
			Map<Integer, Long> cache) {
		int key = (start[0] << 10) | (start[1] << 4) | pieces;
		if (cache.containsKey(key)) return cache.get(key);
		if (totalApple < pieces) {
			cache.put(key, 0l);
			return cache.get(key);
		}
		if (pieces == 1) {
			cache.put(key, 1l);
			return cache.get(key);
		}
		int m = appleCount.length, n = appleCount[0].length;
		int prevSum = 0;
		long mod = (long)(1e9 + 7);
		long numberOfWays = 0;
		for (int i = start[0]; i < m - 1; i++) {
			prevSum += appleCount[i][start[1]][0];
			if (prevSum == 0) continue;
			if (totalApple - prevSum < pieces - 1) break;
			numberOfWays = (numberOfWays + 
					helper(new int[] {i + 1, start[1]}, pieces - 1, appleCount, totalApple - prevSum, cache)) % mod;
		}
		
		prevSum = 0;
		for (int j = start[1]; j < n - 1; j++) {
			prevSum += appleCount[start[0]][j][1];
			if (prevSum == 0) continue;
			if (totalApple - prevSum < pieces - 1) break;
			numberOfWays = (numberOfWays + 
					helper(new int[] {start[0], j + 1}, pieces - 1, appleCount, totalApple - prevSum, cache)) % mod;
		}
		cache.put(key, numberOfWays);
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Problem1444 problem = new Problem1444();
		System.out.println(problem.ways(new String[] {"A..","AAA","..."}, 3));
	}
}
