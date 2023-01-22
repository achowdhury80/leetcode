package com.prep2020.hard;
import java.util.*;
public class Problem1235 {
	/**
	 * O(NlogN)
	 * @param startTime
	 * @param endTime
	 * @param profit
	 * @return
	 */
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, 
        		(x, y) -> (endTime[x] == endTime[y] ? 
        				(startTime[x] - startTime[y]) : (endTime[x] - endTime[y])));
        int[] dp = new int[n];
        dp[0] = profit[arr[0]];
        int result = dp[0];
        // amortized to O(N)
        for (int i = 1; i < n; i++) {
        	dp[i] = profit[arr[i]];
        	for (int j = i - 1; j > -1; j--) {
        		int idx = arr[j];
        		if (endTime[idx] <= startTime[arr[i]]) {
        			dp[i] = Math.max(dp[i], profit[arr[i]] + dp[j]);
        			break;
        		} else {
        			dp[i] = Math.max(dp[i], dp[j]);
        		}
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }	
}
