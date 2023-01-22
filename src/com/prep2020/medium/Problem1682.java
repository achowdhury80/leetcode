package com.prep2020.medium;
public class Problem1682 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		// 1st for length and 2nd for char
		int[][][] dp = new int[n][n][2]; 
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) 
				dp[i][i + 1] = new int[] {2, s.charAt(i) - 'a' + 1};
		}
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j + i - 1 < n; j++) {
				if (s.charAt(j) == s.charAt(j + i - 1) && (s.charAt(j) - 'a' + 1) 
						!= dp[j + 1][j + i - 2][1]) {
					dp[j][j + i - 1][0] = dp[j + 1][j + i - 2][0] + 2;
					dp[j][j + i - 1][1] =  s.charAt(j) - 'a' + 1;
				} else {
					if (dp[j][j + i - 2][0] > dp[j + 1][j + i - 1][0]) 
						dp[j][j + i - 1] = new int[] {dp[j][j + i - 2][0], 
								dp[j][j + i - 2][1]};
					else dp[j][j + i - 1] = new int[] {dp[j + 1][j + i - 1][0], 
							dp[j + 1][j + i - 1][1]};
				}
				
			}
		}
		
		return dp[0][n - 1][0];
    }
	
	public static void main(String[] args) {
		Problem1682 problem = new Problem1682();
		//System.out.println(problem.longestPalindromeSubseq("bbabab"));
		System.out.println(problem.longestPalindromeSubseq("dcbccacdb"));
	}
}
