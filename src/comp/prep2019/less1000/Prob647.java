package comp.prep2019.less1000;

public class Prob647 {
	/*
	 * 
	 * O(N^2) time and space
	 */
	public int countSubstrings(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        int result = n;
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int j = 1; j < n; j++) {
        	for (int i = 0; i < n - 1; i++) {
        		if (i + j < n) {
        			if (s.charAt(i) == s.charAt(i + j) && (j == 1 
        					|| dp[i + 1][i + j - 1])) {
        				dp[i][i + j] = true;
        				result++;
        			}
        		}
        	}
        }
        return result;
    }
}
