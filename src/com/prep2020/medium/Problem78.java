package com.prep2020.medium;
import java.util.*;
public class Problem78 {
	/**
	 * O(2 ^ N)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
        	List<Integer> list = new ArrayList<>();
        	for (int j = n - 1; j > -1; j--) {
        		if (((i >> j) & 1) > 0) list.add(nums[j]);
        	}
        	result.add(list);
        }
        
        return result;
    }
}
