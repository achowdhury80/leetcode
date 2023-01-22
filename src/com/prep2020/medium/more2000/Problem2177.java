package com.prep2020.medium.more2000;

public class Problem2177 {
	/**
	 * O(1)
	 * @param num
	 * @return
	 */
	public long[] sumOfThree(long num) {
        long rem = num % 3, val = num / 3;
        if (rem != 0) return new long[0];
        return new long[] {val - 1, val, val + 1};
    }
}
