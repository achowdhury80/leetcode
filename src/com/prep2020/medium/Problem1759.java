package com.prep2020.medium;

public class Problem1759 {
	/**
	 * O(n)
	 * @param s
	 * @return
	 */
	public int countHomogenous(String s) {
        int n = s.length();
        int result = 0, count = 1, mod = (int)(1e9 + 7);
        for (int i = 1; i < n; i++) {
        	if (s.charAt(i) == s.charAt(i - 1)) count++;
        	else {
        		result = (int)(((1l * count * (count + 1) / 2) + result) % mod);
        		count = 1;
        	}
        }
        result = (int)(((1l * count * (count + 1) / 2) + result) % mod);
        return result;
    }
}
