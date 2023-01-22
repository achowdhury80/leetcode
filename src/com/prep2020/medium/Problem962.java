package com.prep2020.medium;
import java.util.*;
public class Problem962 {
	public int maxWidthRamp(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = nums.length;
        int result = 0;
        for (int i = n - 1; i > -1; i--) {
        	if (treeMap.isEmpty() || treeMap.ceilingKey(nums[i]) == null) {
        		treeMap.put(nums[i], i);
        		continue;
        	}
        	result = Math.max(result, treeMap.ceilingEntry(nums[i]).getValue() - i);
        }
        return result;
    }
}
