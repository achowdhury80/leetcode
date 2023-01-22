package com.prep2020.medium;

public class Problem443 {
	/**
	 * O(N)
	 * @param chars
	 * @return
	 */
	public int compress(char[] chars) {
        int n = chars.length, i = 1, j = 0, count = 1;
        while(i < n) {
        	if (chars[i] == chars[i - 1]) count++;
        	else {
        		chars[j++] = chars[i - 1];
        		if (count > 1) for (char c : ("" + count).toCharArray()) chars[j++] = c;
        		count = 1;
        	}
        	i++;
        }
        chars[j++] = chars[n - 1];
        if (count > 1) for (char c : ("" + count).toCharArray()) chars[j++] = c;
        return j;
    }
}
