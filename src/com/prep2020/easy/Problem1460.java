package com.prep2020.easy;

public class Problem1460 {
	/**
	 * O(1)
	 * @param target
	 * @param arr
	 * @return
	 */
	public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[1001];
        for (int i : arr) counts[i]++;
        for (int i : target) {
        	if (counts[i] == 0) return false;
        	counts[i]--;
        }
        return true;
    }
}
