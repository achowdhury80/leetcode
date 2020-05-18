package comp.prep2019;
import java.util.*;
public class Prob1312 {
	public int minInsertions(String s) {
        //return helper(s, new HashMap<>());
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[][] dp = new int[n][n];
		// i is the number of characters
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j + i <= n; j++) {
				 if (arr[j] == arr[j + i - 1]) {
					 dp[j][j + i - 1] = i > 2 ? dp[j + 1][j + i - 2]: 0;
				 }
				 else {
					 dp[j][j + i - 1] = 1;
					 if (i > 2) {
						 dp[j][j + i - 1] += Math.min(dp[j][i + j - 2], dp[j + 1][i + j - 1]);
					 } 
				 }
			}
		}
		return dp[0][n - 1];
    }
	
	/*private int helper(String s, Map<String, Integer> cache) {
		if ("".equals(s)) return 0;
		if (cache.containsKey(s)) return cache.get(s);
		if (s.length() == 1) {
			cache.put(s, 0);
			return cache.get(s);
		}
		if (s.charAt(0) == s.charAt(s.length() - 1)) 
			cache.put(s, helper(s.substring(1, s.length() - 1), cache));
		else {
			cache.put(s, 1 + Math.min(helper(s.substring(1), cache),
					helper(s.substring(0, s.length() - 1), cache)));
		}
		
		return cache.get(s);
	}*/
}
