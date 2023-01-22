package com.prep2020.medium;
import java.util.*;
public class Problem1387 {
	public int getKth(int lo, int hi, int k) {
		Map<Integer, Integer> cache = new HashMap<>();
		cache.put(1, 0);
		Integer[] arr = new Integer[hi - lo + 1];
		for (int i = lo; i <= hi; i++) arr[i - lo] = i;
		Arrays.sort(arr, (x, y) -> findPower(x, cache) - findPower(y, cache));
		return arr[k - 1];
    }
	
	private int findPower(int num, Map<Integer, Integer> cache) {
		if (cache.containsKey(num)) return cache.get(num);
		if (num % 2 == 0) cache.put(num, 1 + findPower(num / 2, cache));
		else cache.put(num, 1 + findPower(num * 3 + 1, cache));
		return cache.get(num);
	}
}
