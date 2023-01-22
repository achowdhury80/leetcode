package com.prep2020.hard;
import java.util.*;
public class Problem568 {
	public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length, k = days[0].length;
        Map<Integer, Set<Integer>> nextMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == j) continue;
        		if (flights[i][j] == 1) {
        			Set<Integer> set = nextMap.getOrDefault(i, new HashSet<>());
        			set.add(j);
        			nextMap.put(i, set);
        		}
        	}
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) dp[i] = -1;
        for (int i = 0; i < k; i++) {
        	int[] temp = new int[n];
        	for (int j = 0; j < n; j++) temp[j] = -1;
        	for (int j = 0; j < n; j++) {
        		if (dp[j] == -1) continue;
        		temp[j] = Math.max(temp[j], dp[j] + days[j][i]);
        		if (!nextMap.containsKey(j)) continue;
        		for (int next : nextMap.get(j)) {
        			temp[next] = Math.max(temp[next], dp[j] + days[next][i]);         		
        		}
        	}
        	dp = temp;
        }
        int result = 0;
        for (int i = 0; i < n; i++) result = Math.max(result, dp[i]);
        return result;
    }
	
	public static void main(String[] args) {
		Problem568 problem = new Problem568();
		System.out.println(problem.maxVacationDays(new int[][] {{0,1,1},{1,0,1},{1,1,0}},
		new int[][]{{1,3,1},{6,0,3},{3,3,3}}));
		System.out.println(problem.maxVacationDays(new int[][] {{0,0, 0},{0, 0, 0},{0, 0, 0}},
				new int[][]{{1,1,1},{7, 7, 7},{7, 7, 7}}));
	}
}
