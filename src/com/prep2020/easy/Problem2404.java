package com.prep2020.easy;
import java.util.*;
public class Problem2404 {
	public int mostFrequentEven(int[] nums) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
        	if (num % 2 == 1) continue;
        	map.put(num, map.getOrDefault(num, 0) + 1);
        	if (result == -1 || map.get(num) > map.get(result) || map.get(num) == map.get(result) && num < result)
        		result = num;
        }
        return result;
    }
}
