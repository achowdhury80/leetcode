package com.prep2020.easy;

import java.util.*;

public class Problem2357 {
	public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
        	if (num > 0) set.add(num);
        }
        return set.size();
    }
}
