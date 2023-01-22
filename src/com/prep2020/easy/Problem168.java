package com.prep2020.easy;

public class Problem168 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public String convertToTitle(int n) {
		String result = "";
        while(n > 0) {
        	n--;
        	int rem = n % 26;
        	result = (char)(rem + 'A') + result;
        	n /= 26;
        }
        return result;
    }
}
