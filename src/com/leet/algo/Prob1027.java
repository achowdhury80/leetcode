package com.leet.algo;
import java.util.*;
public class Prob1027 {
	/**
	 * dp[i][diff] = taking the element i, what is the max number of elements before with diff
	 * @param A
	 * @return
	 */
	public int longestArithSeqLength(int[] A) {
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        dp[0] = new HashMap<>();
        dp[0].put(0, 1);
        int result = 0;
        for (int i = 1; i < A.length;i++) {
        	for (int j = i - 1; j > -1; j--) {
        		int diff = A[i] - A[j];
        		int count = dp[j].getOrDefault(diff, 1) + 1;
        		result = Math.max(result, count);
        		if (dp[i] == null) dp[i] = new HashMap<>();
        		if (dp[i].containsKey(diff)) count = Math.max(count, dp[i].get(diff));
        		dp[i].put(diff, count);
        	}
        }
        return result;
    }
}
