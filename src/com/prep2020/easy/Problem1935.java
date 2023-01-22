package com.prep2020.easy;

public class Problem1935 {
	/**
	 * O(N)
	 * @param text
	 * @param brokenLetters
	 * @return
	 */
	public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int result = 0;
        for (String w : words) {
        	boolean flag = true;
        	for (char c : w.toCharArray()) {
        		if (brokenLetters.indexOf(c) > -1) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) result++;
        }
        return result;
    }
}
