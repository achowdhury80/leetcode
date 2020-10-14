package comp.prep2019.less1000;

public class Prob516 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int j = 1; j < n; j++) {
        	for (int i = 0; i < n; i++) {
        		if (i + j == n) {
        			break;
        		}
        		if (arr[i] == arr[i + j]) {
        			dp[i][i + j] = 2 + (j == 1 ? 0 : dp[i + 1][i + j - 1]);
        		} else {
        			dp[i][i + j] = Math.max(dp[i][i + j - 1], dp[i + 1][i + j]);
        		}
        	}
        }
        return dp[0][n - 1];
    }
	
	public static void main(String[] args) {
		Prob516 prob = new Prob516();
		System.out.println(prob.longestPalindromeSubseq("bbbab"));
	}
}
