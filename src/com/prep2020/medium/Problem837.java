package com.prep2020.medium;

public class Problem837 {
	public double new21Game(int N, int K, int W) {
		if (K == 0 || K + W <= N) {
            return 1;
        }
        if (N < K) {
            return 0;
        }
        double[] dp = new double[N + 1];
        double unitProb = (1.0 / W);
        double result = 0;
        double sum = 0;
        for (int i = 1; i <= N; i++) {
        	dp[i] = sum * unitProb + (i <= W ? unitProb : 0);
        	if (i < K) {
        		sum += dp[i];
        	}
        	if (i > W) sum -= dp[i - W];
        	if (i >= K) result += dp[i];
        }
        return result;
    }
}
