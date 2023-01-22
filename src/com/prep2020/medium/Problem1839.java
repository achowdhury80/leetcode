package com.prep2020.medium;

public class Problem1839 {
	/**
	 * O(N)
	 * @param word
	 * @return
	 */
	public int longestBeautifulSubstring(String word) {
        int result = 0, start = -1;
        int lastIndex = -1;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	int charIndex = "aeiou".indexOf(c);
        	if (charIndex == lastIndex) continue;
        	if (charIndex == 0) {
        		if (lastIndex == 4) {
        			if (start > -1) {
        				result = Math.max(result, i - start);
        			}
        		} 
        		start = i;
        		lastIndex = 0;
        	} else {
        		if (lastIndex == 4 || (charIndex != lastIndex + 1)) {
        			if (lastIndex == 4 && start > -1) {
        				result = Math.max(result, i - start);
        			}
        			start = -1;
        			lastIndex = -1;
        		} else lastIndex = charIndex;
        	}
        }
        if (start > -1 && lastIndex == 4) result = Math.max(result, word.length() - start);
        return result;
    }
}
