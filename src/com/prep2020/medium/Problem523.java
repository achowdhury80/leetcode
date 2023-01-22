package com.prep2020.medium;
import java.util.*;
public class Problem523 {
	public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int last = 0;
        for (int num : nums) {
        	sum += num;
        	if (set.contains(sum % k)) return true;
        	set.add(last);
        	last = sum % k; 
        }
        return false;
    }
}
