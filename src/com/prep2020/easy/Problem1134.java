package com.prep2020.easy;

public class Problem1134 {
	/**
	 * O(n) n = num.length
	 * @param N
	 * @return
	 */
	public boolean isArmstrong(int N) {
        String s = "" + N;
        int k = s.length();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
        	num += Math.pow(s.charAt(i) - '0', k);
        }
        return num == N;
    }
}
