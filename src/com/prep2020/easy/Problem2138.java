package com.prep2020.easy;

public class Problem2138 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @param fill
	 * @return
	 */
	public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int len = n / k, idx = 0;
        if (n % k != 0) len++;
        String[] result = new String[len];
        for (int i = 0; i < s.length(); i += k) {
        	result[idx] = s.substring(i, Math.min(i + k, s.length()));
        	while(result[idx].length() < k) result[idx] += fill;
        	idx++;
        }
        return result;
    }
}
