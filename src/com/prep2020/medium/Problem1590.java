package com.prep2020.medium;
import java.util.*;
public class Problem1590 {
	public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int i : nums) sum += i;
        int reminder = (int)(sum % p);
        if (reminder == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        sum = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	int curReminder = (int)(sum % p);
        	int prevReminder = (curReminder + p - reminder) % p;
        	if (map.containsKey(prevReminder)) result = Math.min(result, i - map.get(prevReminder));
        	map.put(curReminder, i);
        }
        
        return result == nums.length ? -1 : result;
    }
	
	public static void main(String[] args) {
		Problem1590 problem = new Problem1590();
		//System.out.println(problem.minSubarray(new int[] {6, 3, 5, 2}, 9));
		System.out.println(problem.minSubarray(new int[] {1, 2, 3}, 7));
	}
}
