package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2126 {
	/**
	 * O(nlogN)
	 * @param mass
	 * @param asteroids
	 * @return
	 */
	public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int w : asteroids) {
        	if (w <= m) m += w;
        	else return false;
        }
        return true;
    }
}
