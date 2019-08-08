package com.leet.algo;
import java.util.*;
public class Prob228 {
	public List<String> summaryRanges(int[] nums) {
		int start = 0;
        List<String> result = new ArrayList<>();
        if (nums.length < 1) return result;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != nums[i -1] + 1) {
        		if (start == i - 1) {
        			result.add("" + nums[i -1]);
        		} else result.add(nums[start] + "->" + nums[i -1]);
        		start = i;
        	}
        }
        if (start == nums.length - 1) {
			result.add("" + nums[nums.length -1]);
		} else result.add(nums[start] + "->" + nums[nums.length -1]);
		return result;
    }
}
