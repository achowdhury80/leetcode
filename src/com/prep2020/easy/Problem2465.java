package com.prep2020.easy;

import java.util.*;

public class Problem2465 {
	public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        int i = 0, j = nums.length - 1;
        while(i < j) {
        	double sum = nums[i++] + nums[j--];
        	set.add(sum / 2);
        }
        return set.size();
    }
}
