package com.prep2020.easy;
import java.util.*;
public class Problem2395 {
	public boolean findSubarrays(int[] nums) {
        int sum = nums[0] + nums[1];
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        for (int i = 2; i <nums.length; i++) {
        	sum = (sum - nums[i - 2]) + nums[i];
        	if (set.contains(sum)) return true;
        	set.add(sum);
        }
        return false;
    }
}
