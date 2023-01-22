package com.prep2020.easy;

public class Problem1662 {
	/**
	 * O(m + n)
	 * @param word1
	 * @param word2
	 * @return
	 */
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int idx1 = 0, idx2 = 0;
        while(i < word1.length && j < word2.length) {
        	if (word1[i].charAt(idx1) != word2[j].charAt(idx2)) return false;
        	if (idx1 == word1[i].length() - 1) {
        		idx1 = 0;
        		i++;
        	} else idx1++;
        	if (idx2 == word2[j].length() - 1) {
        		idx2 = 0;
        		j++;
        	} else idx2++;
        }
        return i == word1.length && j == word2.length;
    }
}
