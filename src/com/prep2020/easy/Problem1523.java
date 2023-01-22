package com.prep2020.easy;

public class Problem1523 {
	/**
	 * O(1)
	 * @param low
	 * @param high
	 * @return
	 */
	public int countOdds(int low, int high) {
        if (high % 2 == 1) high++;
        if (low % 2 == 1) low--;
        return (high - low) / 2;
    }
}
