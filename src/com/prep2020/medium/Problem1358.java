package com.prep2020.medium;

public class Problem1358 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int i = 0, j = -1, n = s.length(), result = 0;
        while(i < n) {
        	while (count[0] < 1 || count[1] < 1 || count[2] < 1) {
        		if (j == n - 1) break;
        		j++;
        		count[s.charAt(j) - 'a']++;
        	}
        	if (count[0] > 0 && count[1] > 0 && count[2] > 0) result += (n - j);
        	count[s.charAt(i) - 'a']--;
        	i++;
        }
        return result;
    }
}
