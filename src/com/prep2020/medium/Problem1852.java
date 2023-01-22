package com.prep2020.medium;
import java.util.*;
public class Problem1852 {
	/**
	 * O(N) time and o(K) space
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] distinctNumbers(int[] nums, int k) {
		int n = nums.length, idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        	if (i - k > -1) {
        		map.put(nums[i - k], map.get(nums[i - k]) - 1);
        		if (map.get(nums[i - k]) == 0) map.remove(nums[i - k]);
        	}
        	if (i > k - 2) result[idx++] = map.size();
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1852 problem = new Problem1852();
		System.out.println(problem.distinctNumbers(new int[] {1,  2, 3, 2, 2, 1, 3}, 3));
	}
}
