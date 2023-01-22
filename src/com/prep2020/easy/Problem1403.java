package com.prep2020.easy;
import java.util.*;
public class Problem1403 {
	/**
	 * O(1) time and O(N) space
	 * @param nums
	 * @return
	 */
	public List<Integer> minSubsequence(int[] nums) {
        int[] counts = new int[101];
        int sum = 0;
        for (int i : nums) {
        	counts[i]++;
        	sum += i;
        }
        List<Integer> list = new ArrayList<>();
        int runningSum = 0;
        for (int i = 100; i > 0; i--) {
        	while (counts[i] > 0) {
        		runningSum += i;
        		counts[i]--;
        		list.add(i);
        		if (2 * runningSum > sum) return list;
        	}
        }
        return list;
    }
}
