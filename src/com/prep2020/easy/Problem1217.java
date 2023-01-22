package com.prep2020.easy;

public class Problem1217 {
	/**
	 * O(N)
	 * @param position
	 * @return
	 */
	public int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;
        for (int pos : position) {
        	if (pos % 2 == 0) evenCount++;
        	else oddCount++;
        }
        return Math.min(evenCount, oddCount);
    }
}
