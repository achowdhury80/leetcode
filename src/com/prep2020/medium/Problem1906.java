package com.prep2020.medium;
import java.util.*;
public class Problem1906 {
	public int[] minDifference(int[] nums, int[][] queries) {
        TreeSet<Integer>[] sets = new TreeSet[101];
        for (int i = 1; i < 101; i++) sets[i] = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
        	sets[nums[i]].add(i);
        }
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	int last = 0;
        	int[] q = queries[i];
        	int diff = Integer.MAX_VALUE;
        	if (q[0] == q[1]) {
        		result[i] = -1;
        		continue;
        	}
        	for (int j = 1; j < 101; j++) {
        		Integer ceil = sets[j].ceiling(q[0]);
        		if (ceil !=  null && ceil <= q[1]) {
        			if (last != 0) {
        				diff = Math.min(diff, j - last);
        			}
        			last = j;
        		}
        	}
        	if (diff == Integer.MAX_VALUE) diff = -1;
        	result[i] = diff;
        }
        return result;
    }
}
