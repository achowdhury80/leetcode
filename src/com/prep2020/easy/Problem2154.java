package com.prep2020.easy;

public class Problem2154 {
	public int findFinalValue(int[] nums, int original) {
		boolean[] exists = new boolean[1001];
        for (int i : nums) exists[i] = true;
        while(original <= 1000 && exists[original]) original *= 2;
        return original;
    }
}
