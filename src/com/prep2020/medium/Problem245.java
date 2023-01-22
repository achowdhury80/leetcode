package com.prep2020.medium;

public class Problem245 {
	/**
	 * O(N)
	 * @param wordsDict
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
		int[] pos = new int[] {-1, -1};
		boolean same = word1.equals(word2);
		int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
        	if (wordsDict[i].equals(word1)) {
        		if (!same) {
        			pos[0] = i;
            		if (pos[1] != -1) result = Math.min(result, i - pos[1]);
        		} else {
        			if (pos[0] == -1) pos[0] = i;
        			else {
        				if (pos[1] != -1) pos[0] = pos[1];
        				pos[1] = i;
        				result = Math.min(result, i - pos[0]);
        			} 
        		}
        	} else if (!same && wordsDict[i].equals(word2)) {
        		pos[1] = i;
        		if (pos[0] != -1) result = Math.min(result, i - pos[0]);
        	}
        }
        return result;
    }
}
