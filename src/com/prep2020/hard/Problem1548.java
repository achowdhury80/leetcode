package com.prep2020.hard;
import java.util.*;
public class Problem1548 {
	public List<Integer> mostSimilar(int n, int[][] roads, String[] names, 
			String[] targetPath) {
        int m = targetPath.length;
        Map<String, Integer> cityMap = new HashMap<>();
        for (int i = 0; i < n; i++) cityMap.put(names[i], i);
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        for (int[] r : roads) {
        	nexts[r[0]].add(r[1]);
        	nexts[r[1]].add(r[0]);
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		dp[i][m - j - 1] = j + 1;
        	}
        }
        if (cityMap.containsKey(targetPath[m - 1]))
        	dp[cityMap.get(targetPath[m - 1])][m - 1] = 0;
        
        for (int i = m - 2; i > -1; i--) {
        	for (int j = 0; j < n; j++) {
        		int editDistance 
        			= names[j].equals(targetPath[i]) ? 0 : 1;
        		int min = Integer.MAX_VALUE;
        		for (int next : nexts[j]) 
        			min = Math.min(min, dp[next][i + 1]);
        		dp[j][i] = min + editDistance;
        	}
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < n; i++) {
        	if (dp[i][0] < dp[start][0]) start = i;
        }
        result.add(start);
        for (int i = 1; i < m; i++) {
        	int winner = -1;
        	for (int next : nexts[start]) {
        		if (winner == -1 || dp[next][i] < dp[winner][i]) 
        			winner = next;
        	}
        	start = winner;
        	result.add(start);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1548 problem = new Problem1548();
		System.out.println(problem.mostSimilar(5, 
				new int[][] {{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}}, 
				new String[] {"ATL","PEK","LAX","DXB","HND"}, 
				new String[]{"ATL","DXB","HND","LAX"}));
	}
}
