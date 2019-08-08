package com.leet.algo;

import java.util.Arrays;

public class Prob1048 {
	/**
	 * dp[i] is the longest chain till word[i] keeping word[i] as the last word in the chain
	 * for word[i] go back all words which are one edit distance away.
	 * such a cases gives- dp[i] = 1 + dp[j]
	 * @param words
	 * @return
	 */
	public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        int[] dp = new int[words.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < words.length; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > -1 && words[j].length() > words[i].length() - 2 ; j--) {
        		if (words[j].length() == words[i].length()) continue;
        		if (isOneEditApart(words[j], words[i])) dp[i] = Math.max(dp[i], 1 + dp[j]);
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
	
	private boolean isOneEditApart(String smaller, String larger) {
		boolean toAdd = false;
		for (int i = 0, j = 0; i < smaller.length(); i++, j++) {
			if (smaller.charAt(i) != larger.charAt(j)) {
				i--;
				if(toAdd) return false;
				toAdd = true;
			}
		}
		return true;
	}
}
