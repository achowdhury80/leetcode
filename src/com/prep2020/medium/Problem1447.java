package com.prep2020.medium;
import java.util.*;
public class Problem1447 {
	/**
	 * O(n^2logN)
	 * @param n
	 * @return
	 */
	public List<String> simplifiedFractions(int n) {
        Set<String> set = new HashSet<>();
        for (int j = 2; j <= n; j++) {
	        for (int i = 1; i < j; i++) {
	        	int hcf = findHCF(j, i);
	        	set.add("" + (i / hcf) + "/" + (j / hcf));
	        }
		}
        return new ArrayList<>(set);
    }
	
	private int findHCF(int n, int i) {
		if (i == 0) return n;
		return findHCF(i, n % i);
	}
}
