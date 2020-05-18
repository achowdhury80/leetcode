package comp.prep2019;

public class Prob1000 {
	public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[][] dp = new int[n][n];
        int[] preSum = new int[n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		dp[i][j] = -1;
        	}
        	preSum[i] = stones[i] + (i > 0 ? preSum[i - 1] : 0);
        }
        return dfs(preSum, dp, 0, n - 1, K);
    }
	
	private int dfs(int[] sum, int[][] dp, int i, int j, int k) {
		if (j - i + 1 < k) return 0;
		if (j - i + 1 == k) {
			dp[i][j] = sum[j] - (i > 0 ? sum[i - 1] : 0);
			return dp[i][j];
		}
		if (dp[i][j] != -1) return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		for (int x = i; x + k - 1 < j; x += k - 1) {
			dp[i][j] = Math.min(dp[i][j], dfs(sum, dp, i, x, k) 
					+ dfs(sum, dp, x + 1, j, k));
		}
		if ((i - j) % (k - 1) == 0) dp[i][j] += sum[j] - (i > 0 ? sum[i - 1] : 0);
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		Prob1000 prob = new Prob1000();
		System.out.println(prob.mergeStones(new int[] {3, 2, 4, 1}, 2));
	}
}
