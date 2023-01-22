package com.prep2020.easy;

public class Problem1832 {
	/**
	 * O(N)
	 * @param sentence
	 * @return
	 */
	public boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];
        int count = 0;
        for (char c : sentence.toCharArray()) {
        	int idx = c - 'a';
        	if (!arr[idx]) count++;
        	arr[idx] = true;
        	if (count == 26) return true;
        }
        return false;
    }
}
