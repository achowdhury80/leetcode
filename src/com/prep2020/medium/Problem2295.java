package com.prep2020.medium;
import java.util.*;
public class Problem2295 {
	public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], Arrays.asList(i));
        for (int[] op : operations) {
        	if (map.containsKey(op[0])) {
        		List<Integer> oldList = map.remove(op[0]);
        		List<Integer> newList = map.getOrDefault(op[1], new ArrayList<>());
        		for (int idx : oldList) {
        			nums[idx] = op[1];
        			newList.add(idx);
        		}
        		map.put(op[1], newList);
        	}
        }
        return nums;
    }
}
