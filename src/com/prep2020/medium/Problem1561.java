package com.prep2020.medium;

import java.util.Arrays;

public class Problem1561 {
	/**
	 * O(NlogN)
	 * @param piles
	 * @return
	 */
	public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int i = n - 2, result = 0;
        for (int j = 0; j * 3 < n; j++) {
        	result += piles[i];
        	i -= 2;
        }
        return result;
    }
}
