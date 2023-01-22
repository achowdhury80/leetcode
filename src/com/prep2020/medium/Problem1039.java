package com.prep2020.medium;

public class Problem1039 {
	/**
	 Intuition
	 The connected two points in polygon shares one common edge,
	these two points must be one and only one triangles.
	
	
	Explanation
	dp[i][j] means the minimum score to triangulate A[i] ~ A[j],
	while there is edge connect A[i] and A[j].
	
	We enumerate all points A[k] with i < k < j to form a triangle.
	
	The score of this triangulation is dp[i][j] = dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]
	 * @param A
	 * @return
	 */
	public int minScoreTriangulation(int[] A) {
		int n = A.length;
       int[][] dp = new int[n][n];
       for (int d = 2; d < n; d++) {
       	for (int i = 0; i + d < n; i++) {
       		int j = i + d;
       		dp[i][j] = Integer.MAX_VALUE;
       		for (int k = i + 1; k < j; k++) dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
       		
       	}
       }
       return dp[0][n - 1];
   }
}
