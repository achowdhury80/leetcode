package com.prep2020.easy;

public class Problem243 {
	/**
	 * O(N)
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestDistance(String[] words, String word1, String word2) {
        int w1Index = -1, w2Index = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
        	if (words[i].equals(word1)) {
        		w1Index = i;
        		if (w2Index != -1) result = Math.min(result, w1Index - w2Index);
        	}
        	else if (words[i].equals(word2)) {
        		w2Index = i;
        		if (w1Index != -1) result = Math.min(result, w2Index - w1Index);
        	}
        }
        return result;
    }
}
