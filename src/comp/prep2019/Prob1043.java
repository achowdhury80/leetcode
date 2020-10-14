package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob1043 {
	/**
	 * dp[i] = max sum till i
	 * @param A
	 * @param K
	 * @return
	 */
	public int maxSumAfterPartitioning(int[] A, int K) {
        return helper(A, 0, K, new HashMap<>());
    }
	
	private int helper(int[] A, int start, int k, Map<Integer, Integer> cache) {
		if (start == A.length) return 0;
		if (cache.containsKey(start)) return cache.get(start);
		int max = A[start];
		int sum = Integer.MIN_VALUE;
		for (int i = start; i < start + k && i < A.length; i++) {
			max = Math.max(max, A[i]);
			sum = Math.max(sum, max * (i - start + 1) + helper(A, i + 1, k, cache));
		}
		cache.put(start, sum);
		return sum;
	}
	
	/**
	 * dp[i] = max sum till i
	 * @param A
	 * @param K
	 * @return
	 */
	public int maxSumAfterPartitioning1(int[] A, int K) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
        	int max = Integer.MIN_VALUE;
        	int localMax = A[i];
        	dp[i] = A[i] + dp[i - 1];
        	for (int j = 1; j < K; j++) {
        		if (i - j < 0) break;
        		localMax = Math.max(localMax, A[i - j]);
        		dp[i] = Math.max(dp[i], 
        				(i - j > 0 ? dp[i - j - 1] : 0) + localMax * (j + 1));
        	}
        }
        return dp[A.length - 1];
    }
	
	public static void main(String[] args) {
		Prob1043 prob = new Prob1043();
		System.out.println(prob.maxSumAfterPartitioning(new int[] {1, 15, 7, 9, 2, 
				5, 10}, 3));
	}
}
