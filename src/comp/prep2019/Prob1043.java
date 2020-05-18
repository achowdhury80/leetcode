package comp.prep2019;

public class Prob1043 {
	public int maxSumAfterPartitioning(int[] A, int K) {
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
}
