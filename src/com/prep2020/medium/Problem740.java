package com.prep2020.medium;

import java.util.*;

public class Problem740 {
	/**
	 * O(NlogN) time and O(N) space
	 * @param nums
	 * @return
	 */
	public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
        	treeMap.put(num, treeMap.getOrDefault(num, 0) + num);
        }
        int[] lastsum = new int[] {0, 0}; // 1st with last element, 2nd without lastElement
        int last = -1;
        for (int key : treeMap.keySet()) {
        	int[] newSum = new int[2];
        	if (last + 1 == key) newSum[0] = treeMap.get(key) + lastsum[1];
        	else newSum[0] = treeMap.get(key) + Math.max(lastsum[0], lastsum[1]);
        	newSum[1] = Math.max(lastsum[0], lastsum[1]);
        	last = key;
        	lastsum = newSum;
        }
        return Math.max(lastsum[0], lastsum[1]);
    }
	
	public static void main(String[] args) {
		Problem740 problem = new Problem740();
		System.out.println(problem.deleteAndEarn(new int[] {3, 4, 2}));
		System.out.println(problem.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
	}
}
