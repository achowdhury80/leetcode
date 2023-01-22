package com.prep2020.easy;

import java.util.TreeSet;

public class Problem1385 {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr2) treeSet.add(i);
        int result = 0;
        for (int i : arr1) {
        	int lowest = i - d, highest = i + d;
        	Integer val = treeSet.ceiling(lowest);
        	if (val == null || val > highest) result++;
        }
        return result;
    }
}
