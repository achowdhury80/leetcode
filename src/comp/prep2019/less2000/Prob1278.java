package comp.prep2019.less2000;

public class Prob1278 {
	public int palindromePartition(String s, int k) {
        int n = s.length();
        if (n == k) return 0;
        // dp[i][j] gives number of characters needs to be modified to make substring
        // ith index to jth index palindromme
        int[][] dp = new int[n][n];
        for (int j = 1; j < n; j++) {
        	for (int i = 0; i + j < n; i++) {
        		dp[i][i + j] = j == 1 ? 0 : dp[i + 1][i + j - 1];
        		if (s.charAt(i) != s.charAt(i + j)) dp[i][i + j]++;
        	}
        }
        // arr[i][j] = min number of changes needed to have j palindromes for the 
        // substring 0th to jth index
        int[][] arr = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
        	arr[i][1] = dp[0][i];
        }
        for (int i = 2; i <= k; i++) {
        	for (int j = i; j < n; j++) {
        		arr[j][i] = Integer.MAX_VALUE;
        		for (int l = j; l > i - 2; l--) {
        			arr[j][i] = Math.min(arr[j][i], arr[l - 1][i - 1] + dp[l][j]);
        		}
        	}
        }
        return arr[s.length() - 1][k];
    }
	
	public static void main(String[] args) {
		Prob1278 prob = new Prob1278();
		System.out.println(prob.palindromePartition("abc", 2));
	}
}
