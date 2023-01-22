package com.prep2020.medium;
import java.util.*;
public class Problem799 {
	public double champagneTower(int poured, int query_row, int query_glass) {
		Map<Integer, Double> cache = new HashMap<>();
		cache.put(0, poured + 0.);
		double received = helper(query_row, query_glass, cache);
		if (received > 1) return 1.0;
		return received;
    }
	
	private double helper(int query_row, int query_glass, 
			Map<Integer, Double> cache) {
		int key = (query_row << 7) | query_glass;
		if (cache.containsKey(key)) return cache.get(key);
		double left = (query_glass == 0) ? 0 
				: helper(query_row - 1, query_glass - 1, cache);
		if (left <= 1) left = 0;
		else left = (left - 1) / 2;
		double right = (query_glass == query_row) ? 0 
				: helper(query_row - 1, query_glass, cache);
		if (right <= 1) right = 0;
		else right = (right - 1) / 2;
		cache.put(key, left + right);
		return cache.get(key);
	}
	
	public static void main(String[] args) {
		Problem799 problem = new Problem799();
		System.out.println(problem.champagneTower(2, 1, 1));
	}
}
