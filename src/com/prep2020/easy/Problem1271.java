package com.prep2020.easy;

public class Problem1271 {
	/**
	 * O(logN)
	 * @param num
	 * @return
	 */
	public String toHexspeak(String num) {
        long n = Long.parseLong(num);
        if (n == 0) return "O";
        String result = "";
        while(n > 0) {
        	int last4 = (int)(n & 15);
        	if (last4 == 0) result = "O" + result;
        	else if (last4 == 1) result = "I" + result;
        	else if (last4 > 9) result = ((char)('A' + (last4 - 10))) + result;
        	else return "ERROR";
        	n >>= 4;
        }
        return result;
    }
}
