package com.prep2020.medium;
import java.util.*;
public class Problem1947 {
	/**
	 * O((n^2) *(2^n))
	 * @param students
	 * @param mentors
	 * @return
	 */
	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        Map<Integer, Integer> map = populateCompatibilityCache(students, mentors);
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < (1 << n); j++) {
        		if (Integer.bitCount(j) == i) {
        			for (int k = 0; k < n; k++) {
        				if (((1 << k) & j) != 0) continue;
        				int newJ = (j | (1 << k));
        				dp[i][newJ] = Math.max(dp[i][newJ], (i == 0 ? 0 : dp[i - 1][j]) + findCompatibility(i, k, map));
        			}
        		}
        	}
        }
        return dp[n - 1][(1 << n) - 1];
    }

	private Map<Integer, Integer> populateCompatibilityCache(int[][] students, int[][] mentors) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < mentors.length; j++) {
				int key = ((j << 3) | i);
				int compatibility = 0;
				for (int k = 0; k < students[i].length; k++) {
					if (students[i][k] == mentors[j][k]) compatibility++;
				}
				map.put(key, compatibility);
			}
		}
		return map;
	}
	
	private int findCompatibility(int student, int mentor, Map<Integer, Integer> map) {
		return map.get(((mentor << 3) | student));
	}
	
	
	public static void main(String[] args) {
		Problem1947 problem = new Problem1947();
		System.out.println(problem.maxCompatibilitySum(new int[][] {{1,1,0},{1,0,1},{0,0,1}}, new int[][] {{1,0,0},{0,0,1},{1,1,0}}));
	}
	
}
