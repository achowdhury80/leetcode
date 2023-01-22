package com.prep2020.easy;

public class Problem387 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (arr[c - 'a'] == Integer.MAX_VALUE) arr[c - 'a'] = i;
        	else arr[c - 'a'] = -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i : arr) {
        	if (i > -1) result = Math.min(result, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
