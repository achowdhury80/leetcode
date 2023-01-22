package com.prep2020.easy;
import java.util.*;
public class Problem202 {
	/**
	 * O(logn) time and space
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();
        while(n > 1) {
        	seen.add(n);
        	n = findSquareSum(n);
        	if (seen.contains(n)) return false;
        }
        return true;
    }

	private int findSquareSum(int n) {
		int result = 0;
		while(n > 0) {
			int rem = n % 10;
			result += rem * rem;
			n /= 10;
		}
		return result;
	}
}
