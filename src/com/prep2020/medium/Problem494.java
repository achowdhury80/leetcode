package com.prep2020.medium;
import java.util.*;
public class Problem494 {
	/**
	 * Time complexity: O(t \cdot n)O(t⋅n). The memo array of size O(t \cdot n)O(t⋅n) has been filled just once. Here, tt refers to the sum of the numsnums array and nn refers to the length of the numsnums array.

Space complexity: O(t \cdot n)O(t⋅n). The depth of recursion tree can go up to nn. The memo array contains t \cdot nt⋅n elements.
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target, new HashMap<>());
    }
	
	private int helper(int[] nums, int start, int target, Map<Integer, Integer> map) {
		int key = (target << 5) | start;
		if (start == nums.length) {
			if (target == 0) return 1;
			return 0;
		}
		if (map.containsKey(key)) return map.get(key);
		int result = helper(nums, start + 1, target - nums[start], map)
				+ helper(nums, start + 1, target + nums[start], map);
		map.put(key, result);
		return result;
	}
}
