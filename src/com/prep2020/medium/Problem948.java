package com.prep2020.medium;

import java.util.Arrays;

public class Problem948 {
	/**
	 * O(nlogn)
	 * @param tokens
	 * @param power
	 * @return
	 */
	public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int result = 0, score = 0;
        int i = 0, j = tokens.length - 1;
        while(i <= j) {
        	if (tokens[i] <= power) {
        		score++;
        		power -= tokens[i];
        		result = Math.max(result, score);
        		i++;
        	} else {
        		if (score == 0) break;
        		score--;
        		power += tokens[j];
        		j--;
        	}
        }
        return result;
    }
}
