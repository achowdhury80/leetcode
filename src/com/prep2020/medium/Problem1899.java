package com.prep2020.medium;

public class Problem1899 {
	/**
	 * O(N)
	 * @param triplets
	 * @param target
	 * @return
	 */
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] trip : triplets) {
        	if (trip[0] > target[0] || trip[1] > target[1] 
        			|| trip[2] > target[2]) continue;
        	for (int i = 0; i < 3; i++) 
        		if (trip[i] == target[i]) found[i] = true;
        }
        return found[0] && found[1] && found[2];
    }
}
