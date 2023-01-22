package com.prep2020.hard;
import java.util.*;
public class Problem975 {
	/**
	 * (N^2 logN) and O(N) space
	 * @param arr
	 * @return
	 */
	public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        // dp[i][0] means starting from ith index and even numbered jump 
        //
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n - 1], n - 1);
        int result = 1;
        for (int i = n - 2; i > -1; i--) {
        	Map.Entry<Integer, Integer> ceiling = treeMap.ceilingEntry(arr[i]);
        	if (ceiling != null && dp[ceiling.getValue()][0]) {
        		dp[i][1] = true;
        		result++;
        	}
        	Map.Entry<Integer, Integer> floor = treeMap.floorEntry(arr[i]);
        	if (floor != null && dp[floor.getValue()][1]) dp[i][0] = true;
        	treeMap.put(arr[i], i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem975 problem = new Problem975();
		System.out.println(problem.oddEvenJumps(new int[] {10, 13, 12, 14, 15}));
	}
}
