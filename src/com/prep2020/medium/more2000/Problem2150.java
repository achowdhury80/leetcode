package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2150 {
	/**
	 * O(nlogn)
	 * @param nums
	 * @return
	 */
	public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1 || (nums[1] != nums[0] 
        		&& nums[1] != nums[0] + 1)) result.add(nums[0]);
        for (int i = 1; i < n - 1; i++) {
        	if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1] 
        			|| nums[i] - 1 == nums[i - 1] 
        					|| nums[i] + 1 == nums[i + 1]) continue;
        	result.add(nums[i]);
        }
        if (n > 1 && (nums[n - 1] != nums[n - 2] 
        		&& nums[n - 1] != nums[n - 2] + 1)) 
        	result.add(nums[n - 1]);
        return result;
    }
}
