package com.prep2020.easy;

public class Problem1903 {
	/**
	 * O(N)
	 * @param num
	 * @return
	 */
	public String largestOddNumber(String num) {
       for (int i = num.length() - 1; i > -1; i--) {
    	   int val = num.charAt(i) - '0';
    	   if (val % 2 == 1) return num.substring(0, i + 1);
       }
       return "";
    }
}
