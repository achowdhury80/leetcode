package com.prep2020.hard;
import java.util.*;
public class Problem2009 {
	public int minOperations(int[] nums) {
		int n = nums.length;
		if (n == 1) return 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
        	int idx = Collections.binarySearch(list, num);
        	if (idx < 0) {
        		idx = -(idx + 1);
        		list.add(idx, num);
        	}
        }
        int result = Integer.MAX_VALUE, start = 0;
        for (int i = 1; i < list.size(); i++) {
        	int max = list.get(i);
        	int min = max - n + 1;
        	while(list.get(start) < min) start++;
        	int count = i - start + 1;
        	result = Math.min(result, n - count);
        }
        return result;
    }
}
