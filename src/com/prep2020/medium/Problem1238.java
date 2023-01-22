package com.prep2020.medium;
import java.util.*;
public class Problem1238 {
	/**
	 * O(2^n)
	 * @param n
	 * @param start
	 * @return
	 */
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		result.add(1);
		int cur = (1 << 1);
		for (int i = 2; i <= n; i++) {
			int size = result.size();
			for (int j = size - 1; j > -1; j--) result.add(cur | result.get(j));
			cur <<= 1;
		}
		while(result.get(0) != start) result.add(result.remove(0));
		return result;
    }
}
