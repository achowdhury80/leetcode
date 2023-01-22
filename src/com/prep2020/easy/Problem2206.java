package com.prep2020.easy;

public class Problem2206 {
	public boolean divideArray(int[] nums) {
        int[] counts = new int[501];
        for (int i : nums) counts[i]++;
        for (int i = 0; i < counts.length; i++) if (counts[i] % 2 != 0) return false;
        return true;
    }
}
