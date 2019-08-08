package com.leet.algo;
import java.util.*;
public class Prob873 {

	public int lenLongestFibSubseq(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(A[i], i);
		int result = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = i + 1; j < n; j++) {
        		int target = A[j] - A[i];
        		int max = map.getOrDefault(target, -1);
        		dp[i][j] = (max == -1 || max >= i) ? 2 : 1 + dp[max][i];
        		result = Math.max(result, dp[i][j]);
        	}
        }
        return result > 2 ? result : 0;
    }
	
	public static void main(String[] args) {
		Prob873 prob = new Prob873();
		System.out.println(prob.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
	}
}
