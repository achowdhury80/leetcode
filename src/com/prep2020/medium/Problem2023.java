package com.prep2020.medium;
import java.util.*;
public class Problem2023 {
	public int numOfPairs(String[] nums, String target) {
		Map<String, Integer> map = new HashMap<>();
        for (String num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int result = 0;
        for (String num : nums) {
        	if (target.startsWith(num)) {
        		String suffix = target.substring(num.length());
        		if ("".equals(suffix)) continue;
        		int count = map.getOrDefault(suffix, 0);
        		if (count == 0 || num.equals(suffix) && count == 1) continue;
        		if (num.equals(suffix)) result += (count - 1);
        		else result += count;
        	}
        }
        return result;
    }
	public int numOfPairs1(String[] nums, String target) {
		int n = target.length();
        Map<Integer, Integer> prefix = new HashMap<>(), 
        		suffix = new HashMap<>();
        int result = 0;
        for (String num : nums) {
        	int size = num.length();
        	if (target.startsWith(num)) {
        		result += suffix.getOrDefault(n - size, 0);
        	}
        	if (target.endsWith(num)) {
        		result += prefix.getOrDefault(n - size, 0);
        	}
        	if (target.startsWith(num)) {
        		prefix.put(size, 1 + prefix.getOrDefault(size, 0));
        	}
        	if (target.endsWith(num)) {
        		suffix.put(size, 1 + suffix.getOrDefault(size, 0));
        	}
        }
        return result;
    }
}
