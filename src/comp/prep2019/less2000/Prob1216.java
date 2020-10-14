package comp.prep2019.less2000;
import java.util.*;
public class Prob1216 {
	
	private int findLongestPalindromicSquence(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) dp[i][i] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j >= n) break;
				if (s.charAt(j) == s.charAt(i + j)) 
					dp[j][i + j] = 2 + (i == 1 ? 0 : dp[j + 1][i + j - 1]);
				else dp[j][i + j] = Math.max(dp[j + 1][i + j], dp[j][i + j - 1]);
			}
		}
		return dp[0][n - 1];
	}
	
	public boolean isValidPalindrome(String s, int k) {
		int lpsLength = findLongestPalindromicSquence(s);
		return s.length() - lpsLength <= k;
    }
	/**
	 * find number of chars to be deleted
	 * @param s
	 * @param start
	 * @param end
	 * @param cache
	 * @return
	 */
	private int helper(String s, int start, int end, 
			Map<String, Integer> cache) {
		if (start >= end) return 0;
		String key = start + "#" + end;
		if (!cache.containsKey(key)) {
			if (s.charAt(start) == s.charAt(end)) {
				cache.put(key, helper(s, start + 1, end - 1, cache));
			} else {
				cache.put(key, 1 + Math.min(
						helper(s, start + 1, end, cache), 
						helper(s, start, end - 1, cache)));
			}
		}
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Prob1216 prob = new Prob1216();
		System.out.println(prob.isValidPalindrome("abcdeca", 2));
	}
}
