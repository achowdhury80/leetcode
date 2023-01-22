package com.prep2020.hard;
import java.util.*;
public class Problem60 {
	public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        return getPermutation(list, k - 1, new HashMap<>());
    }

	private String getPermutation(List<Integer> list, int k, Map<Integer, Integer> factorialCache) {
		if (list.size() == 1) return "" + list.get(0);
		if (k == 0) {
			String s = "";
			for (int i : list) s += i;
			return s;
		}
		int n = list.size();
		int variation = factorial(n - 1, factorialCache);
		int div = k / variation;
		String result = "" + list.remove(div);
		return result + getPermutation(list, k % variation, factorialCache);
		
	}
	
	private int factorial(int n, Map<Integer, Integer> factorialCache) {
		if (n == 1) return 1;
		if (factorialCache.containsKey(n)) return factorialCache.get(n);
		int result = n * factorial(n - 1, factorialCache);
		factorialCache.put(n, result);
		return result;
	}
}
