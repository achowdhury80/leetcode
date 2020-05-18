package comp.prep2019;

import java.util.Arrays;

public class Prob1326 {
	public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1]; // dp[i] is the max distance it can reach 
        //using oene tap
        Arrays.fill(dp, -1);
        for (int i = 0; i <= n; i++) {
        	if (ranges[i] == 0) continue;
        	int left = Math.max(0, i - ranges[i]), 
        			right = Math.min(n, i + ranges[i]);
        	for (int j = left; j <= right; j++) {
        		dp[j] = Math.max(dp[j], right);
        	}
        }
        int result = 0, pos = 0;
        while(pos < n) {
        	if (dp[pos] == -1) return -1;
        	int right = dp[pos];
        	if (pos == right) return -1;
        	pos = right;
        	result++;
        }
        return result;
    }
}
