package com.prep2020.medium;

public class Problem1400 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @return
	 */
	public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        if (k == n) return true;
        boolean[] arr = new boolean[26];
        int count = 0;
        for (char c : s.toCharArray()) {
        	int idx = c - 'a';
        	if (arr[idx]) {
        		arr[idx] = false;
        		count--;
        	} else {
        		arr[idx] = true;
        		count++;
        	}
        }
        return count <= k;
    }
}
