package com.prep2020.easy;

public class Problem1323 {
	/**
	 * O(N) time and space
	 * @param num
	 * @return
	 */
	public int maximum69Number (int num) {
        String s = "" + num;
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '6') {
        		idx = i;
        		break;
        	}
        }
        if (idx == -1) return num;
        return Integer.parseInt(s.substring(0, idx) + "9" + s.substring(idx + 1));
    }
}
