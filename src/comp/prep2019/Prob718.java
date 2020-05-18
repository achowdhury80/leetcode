package comp.prep2019;

public class Prob718 {
	public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        // dp[i][j] is length of common subarray starting at ith elem of A 
        // and jth elem of B
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = m - 1; i > -1; i--) {
        	for (int j = n - 1; j > -1; j--) {
        		dp[i][j] = A[i] == B[j] ? 1 + (dp[i + 1][j + 1]) : 0;
        		result = Math.max(result, dp[i][j]);
        	}
        }
        return result;
    }
}
