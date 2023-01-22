package com.prep2020.medium;
import java.util.*;
public class Problem1887 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
        	treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        int result = 0, step = 0;
        
        for (int key : treeMap.keySet()) {
        	result += step * treeMap.get(key);
        	step++;
        }
        return result;
    }
}
