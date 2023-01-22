package com.prep2020.medium.more2000;

public class Problem2109 {
	/**
	 * O(N)
	 * @param s
	 * @param spaces
	 * @return
	 */
	public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j= 0; j < s.length(); j++) {
        	if (i < spaces.length && spaces[i] == j) {
        		sb.append(' ');
        		i++;
        	}
        	sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
