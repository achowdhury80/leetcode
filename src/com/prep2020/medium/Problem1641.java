package com.prep2020.medium;
public class Problem1641 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	 public int countVowelStrings(int n) {
		 int[] dp = new int[] {1, 1, 1, 1, 1};
	     for (int i = 2; i <= n; i++) {
	    	 int[] temp = new int[5];
	    	 for (int j = 0; j < 5; j++) {
	    		 for (int k = j; k < 5; k++) {
	    			 temp[k] += dp[j];
	    		 }
	    	 }
	    	 dp = temp;
	     }
	     int result = 0;
	     for (int i = 0; i < 5; i++) result += dp[i];
	     return result;
	 }
	 
	 public static void main(String[] args) {
		 Problem1641 problem = new Problem1641();
		 System.out.println(problem.countVowelStrings(2));
	 }
}
