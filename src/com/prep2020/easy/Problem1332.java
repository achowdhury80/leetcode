package com.prep2020.easy;

public class Problem1332 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int removePalindromeSub(String s) {
        if("".equals(s)) return 0;
        int i = 0, j = s.length() - 1;
        while(i < j) {
        	if (s.charAt(i++) != s.charAt(j--)) return 2;
        }
        return 1;
    }
}
