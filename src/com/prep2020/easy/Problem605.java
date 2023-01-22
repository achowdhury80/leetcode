package com.prep2020.easy;

public class Problem605 {
	/**
	 * O(N)
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
        	if (flowerbed[i] == 0) {
        		if ((i == 0 || flowerbed[i - 1] == 0) 
        				&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        			n--;
        			flowerbed[i] = 1;
        		}
        	}
        }
        return n == 0;
    }
}
