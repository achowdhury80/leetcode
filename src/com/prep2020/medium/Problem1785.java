package com.prep2020.medium;

public class Problem1785 {
	/**
	 * O(N)
	 * @param nums
	 * @param limit
	 * @param goal
	 * @return
	 */
	public int minElements(int[] nums, int limit, int goal) {
		long target = goal;
        for (int i : nums) target -= i;
        target = Math.abs(target);
        int result = (int)(target / limit);
        if (target % limit > 0) result++;
        return result;
    }
}
