package com.prep2020.medium;
import java.util.*;
public class Problem1027 {
	/**
	 * O(N^2) time and O(N) space
	 * @param A
	 * @return
	 */
	public int longestArithSeqLength(int[] A) {
        Map[] dp = new Map[A.length];
        for (int i = 0; i < A.length; i++) dp[i] = new HashMap<>();
        int result = 1;
        for (int i = 1; i < A.length; i++) {
        	for (int j = i - 1; j > -1; j--) {
        		int diff = A[i] - A[j];
        		if (dp[i].containsKey(diff)) continue;
        		int len = (int)dp[i].getOrDefault(diff, 0);
        		dp[i].put(diff, (int)Math.max(len, (int)dp[j].getOrDefault(diff, 1) + 1));
        		result = Math.max(result, (int)dp[i].get(diff));
        	}
        }
        return result;
    }
}
