package com.prep2020.medium;

public class Problem319 {
	/**
	 * O(N^(1/2))
	 * @param n
	 * @return
	 */
	public int bulbSwitch(int n) {
        int result = 0;
        for (int i = 1; i * i <= n; i++) result++;
        return result;
    }
}
