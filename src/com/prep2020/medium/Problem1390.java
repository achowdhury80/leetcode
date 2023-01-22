package com.prep2020.medium;
import java.util.*;
public class Problem1390 {
	public int sumFourDivisors(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		for (int num : nums) result += findSum(num, map);
		return result;
    }
	
	private int findSum(int num, Map<Integer, Integer> map) {
		if (map.containsKey(num)) return map.get(num);
		boolean found = false;
		int result = 1 + num;
		map.put(num, 0);
		for (int i = 2; i * i <= num; i++) {
			if (i * i == num) return 0;
			if (num % i == 0) {
				if (found) return 0;
				result += i + num / i;
				found = true;
			}
		}
		if (!found) return 0;
		map.put(num, result);
		return result;
	}
}
