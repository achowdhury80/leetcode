package com.prep2020.easy;
import java.util.*;
public class Problem228 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if(nums.length < 1) return result;
		int start = nums[0], last = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != last + 1) {
				if (start == last) result.add("" + start);
				else result.add(start + "->" + last);
				start = nums[i];
			} 
			last = nums[i];
		}
		if (start == last) result.add("" + start);
		else result.add(start + "->" + last);
		return result;
    }
}
