package com.prep2020.easy;
import java.util.*;
public class Problem163 {
	/**
	 * O(N)
	 * @param nums
	 * @param lower
	 * @param upper
	 * @return
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		for (int num : nums) {
        	if (num < lower) {
        		continue;
        	} else if (num == lower) {
        		lower++;
        		continue;
        	} else if (num <= upper) {
        		if (num == lower + 1) result.add("" + lower);
        		else result.add(lower + "->" + (num - 1));
        		lower = num + 1;
        		if (num == upper) break;
        	} else if (num > upper) {
        		if (lower == upper) result.add("" + lower);
        		else result.add(lower + "->" + upper);
        		lower++;
        	}
        }
		if (lower == upper) result.add("" + lower);
		else if (lower < upper) result.add(lower + "->" + upper);
        return result;
    }
	
	public static void main(String[] args) {
		Problem163 prob = new Problem163();
		System.out.println(prob.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
	}
}
