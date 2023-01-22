package com.prep2020.easy;

public class Problem942 {
	/**
	 * O(N)
	 * @param S
	 * @return
	 */
	public int[] diStringMatch(String S) {
        int min = 0, max = S.length();
        int[] result = new int[S.length() + 1];
        int idx = 0;
        for (char c : S.toCharArray()) {
        	if (c == 'I') result[idx++] = min++;
        	else result[idx++] = max--;
        }
        result[idx] = min;
        return result;
    }
}
