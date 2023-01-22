package com.prep2020.medium;

public class Problem1017 {
	/**
	 * O(logN)
	 * @param N
	 * @return
	 */
	public String baseNeg2(int N) {
        int a = 1;
        while(a < N) a = (a << 2) + 1;
        return Integer.toBinaryString(a ^ (a - N));
    }
}
