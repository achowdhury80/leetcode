package com.prep2020.easy;

public class Problem1189 {
	/**
	 * O(N)
	 * @param text
	 * @return
	 */
	public int maxNumberOfBalloons(String text) {
       String target = "balloon";
       int[] counts = new int[26];
       for (int i = 0; i < 26; i++) counts[i] = -1;
       for (char c : target.toCharArray()) counts[c - 'a'] = 0;
       for (char c : text.toCharArray()) {
    	   int idx = c - 'a';
    	   if (counts[idx] > -1) counts[idx]++;
       }
       int result = 0;
       while(true) {
    	   for (char c : target.toCharArray()) {
    		   int idx = c - 'a';
    		   if (counts[idx] > 0) {
    			   counts[idx]--;
    		   } else return result;
    	   }
    	   result++;
       }
    }
	
	public static void main(String[] args) {
		Problem1189 problem = new Problem1189();
		System.out.println(problem.maxNumberOfBalloons("balloon"));
	}
}
