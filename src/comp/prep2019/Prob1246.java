package comp.prep2019;

public class Prob1246 {
	public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j + i <= n; j++) {
        		dp[j][j + i - 1] = Integer.MAX_VALUE;
        		if (arr[j] == arr[j + i - 1]) {
        			dp[j][j + i - 1] = i == 2 ? 1 : dp[j + 1][j + i - 2];
        		} 
        		for (int k = j; k < j + i - 1; k++) {
        			dp[j][j + i - 1] = Math.min(dp[j][j + i - 1], 
        					dp[j][k] + dp[k + 1][j + i - 1]);
        		}
        	}
        }
        return dp[0][n - 1];
    }
	
	public static void main(String[] args) {
		Prob1246 prob = new Prob1246();
		System.out.println(prob.minimumMoves(
				new int[] {1,4,1,1,2,3,2,1}));
	}
}
