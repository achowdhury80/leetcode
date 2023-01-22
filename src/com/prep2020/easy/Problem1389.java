package com.prep2020.easy;
import java.util.*;
public class Problem1389 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @param index
	 * @return
	 */
	public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	target.add(index[i], nums[i]);
        }
        int[] result = new int[target.size()];
        for (int i = 0; i < result.length; i++) result[i] = target.get(i);
        return result;
    }
}
