package com.prep2020.easy;

public class Problem2341 {
	public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        for (int i : nums) arr[i]++;
        int[] result = new int[2];
        for (int i = 0; i < 101; i++) {
        	result[0] += arr[i] / 2;
        	result[1] += arr[i] % 2;
        }
        return result;
    }
}
