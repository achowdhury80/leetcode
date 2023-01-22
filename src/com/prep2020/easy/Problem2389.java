package com.prep2020.easy;

import java.util.*;

public class Problem2389 {
	public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	treeMap.put(sum, i + 1);
        }
        treeMap.put(0, 0);
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
        	Map.Entry<Integer, Integer> entry = treeMap.floorEntry(queries[i]);
        	result[i] = entry.getValue();
        }
        return result;
    }
}
