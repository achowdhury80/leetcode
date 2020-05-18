package comp.prep2019;

import java.util.Arrays;

public class Prob960 {
	/**
	 * https://leetcode.com/problems/delete-columns-to-make-sorted-iii/solution/
	 * 
	 * dp[k] be the number of columns that are kept in answering the question for 
	 * input [row[k:] for row in A]
	 * @param A
	 * @return
	 */
	public int minDeletionSize(String[] A) {
        int n = A[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 2; i > -1; i--) {
        	search: for (int j = i + 1; j < n; j++) {
        		for (String s : A) {
        			if (s.charAt(i) > s.charAt(j)) continue search;
        		}
                dp[i] = Math.max(dp[i], 1 + dp[j]);
        	}
        }
        int kept = 1;
        for (int x : dp) kept = Math.max(kept, x);
        return n - kept;
    }
}
