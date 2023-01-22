package com.prep2020.medium;

import java.util.*;

public class Problem1968 {
	public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
        	int temp = nums[i];
        	nums[i] = nums[i + 1];
        	nums[i + 1] = temp;
        }
        return nums;
    }
}
