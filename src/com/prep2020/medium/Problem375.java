package com.prep2020.medium;
import java.util.*;
public class Problem375 {
	/**
	 * O(N^2) time and space
	 * @param n
	 * @return
	 */
	public int getMoneyAmount(int n) {
        return helper(1, n, new HashMap<>());
    }
	
	private int helper(int start, int end, Map<Integer, Integer> cache) {
		int key = (start << 8) | end;
		if (cache.containsKey(key)) return cache.get(key);
		if (start == end) cache.put(key, 0);
		else {
			int result = Integer.MAX_VALUE;
			for (int i = start; i < end; i++) {
				int cur = i + Math.max((i > start ? helper(start, i - 1, cache) : 0), 
						(i < end ? helper(i + 1, end, cache) : 0));
				result = Math.min(result, cur);
			}
			cache.put(key, result);
		}
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Problem375 problem = new Problem375();
		System.out.println(problem.getMoneyAmount(1));
		System.out.println(problem.getMoneyAmount(2));
		System.out.println(problem.getMoneyAmount(10));
	}
			
}
