package com.prep2020.medium;

import java.util.Arrays;

public class Problem1798 {
	/**
	 * O(nlogN)
	 * @param coins
	 * @return
	 */
	public int getMaximumConsecutive(int[] coins) {
        int result = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
        	if (coin <= result + 1) result += coin;
        	else break;
        }
        return result + 1;
    }
}
