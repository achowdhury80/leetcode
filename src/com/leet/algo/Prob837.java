package com.leet.algo;
public class Prob837 {
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
	
	public static void main(String[] args) {
		Prob837 prob = new Prob837();
		System.out.println(prob.new21Game(10, 1, 10));
		System.out.println(prob.new21Game(21, 17, 10));
		System.out.println(prob.new21Game(0, 0, 1));
	}
}
