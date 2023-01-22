package com.prep2020.easy;

public class Problem1544 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
        	if (result.length() > 0 
        			&& (
        				(Character.isUpperCase(c) && result.charAt(result.length() - 1) == Character.toLowerCase(c)) 
        				|| (Character.isLowerCase(c) && result.charAt(result.length() - 1) == Character.toUpperCase(c)))) {
        		result.deleteCharAt(result.length() - 1);
        	} else result.append(c);
        }
        return result.toString();
    }
}
