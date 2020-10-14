package comp.prep2019;

public class Prob718 {
	/**
	 * O(M *N) time and space
	 * @param A
	 * @param B
	 * @return
	 */
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
	public int findLength1(int[] A, int[] B) {
        int m = A.length, n = B.length;
        // dp[i][j] is length of common subarray starting at ith elem of A 
        // and jth elem of B
        int[][] dp = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		dp[i + 1][j + 1] = (A[i] == B[j] ? 1 + dp[i][j] : 0);
        		result = Math.max(result, dp[i + 1][j + 1]);
        	}
        }
        return result;
    }
}
