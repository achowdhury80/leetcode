package com.prep2020.easy;

public class Problem1768 {
	/**
	 * O(N)
	 * @param word1
	 * @param word2
	 * @return
	 */
	public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < Math.min(word1.length(), word2.length()); i++) {
        	sb.append(word1.charAt(i));
        	sb.append(word2.charAt(i));
        }
        
        if (i < word1.length()) sb.append(word1.substring(i));
        else if (i < word2.length()) sb.append(word2.substring(i));
        return sb.toString();
    }
}
