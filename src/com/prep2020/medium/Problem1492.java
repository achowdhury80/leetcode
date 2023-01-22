package com.prep2020.medium;
import java.util.*;
public class Problem1492 {
	/**
	 * O(sqrt(N)) time and space
	 * @param n
	 * @param k
	 * @return
	 */
	public int kthFactor(int n, int k) {
        List<Integer> smallerFactors = new ArrayList<>(), largerFactors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
        	if (n % i == 0) {
        		smallerFactors.add(i);
        		if (smallerFactors.size() == k) return i;
        		if (n != i * i) largerFactors.add(0, n / i);
        	}
        }
        smallerFactors.addAll(largerFactors);
        if (k <= smallerFactors.size()) return smallerFactors.get(k - 1);
        return -1;
    }
}
