package com.prep2020.medium;
import java.util.*;
public class Problem1201 {
	/**
	 * https://leetcode.com/problems/ugly-number-iii/discuss/387780/JavaC%2B%2B-Binary-Search-with-Venn-Diagram-Explain-Math-Formula
	 * @param n
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int nthUglyNumber(int n, int a, int b, int c) {
		int MAX_ANS = (int) 2e9;
		int left = 0, right = MAX_ANS, result = 0;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if (count(mid, a, b, c) >= n) {
				result = mid;
				right = mid - 1;
			} else left = mid + 1;
		}
		return result;
    }
	
	private int count(long num, long a, long b, long c) {
		return (int)(num / a + num / b + num / c 
				- num / lcm(a, b) - num / lcm(b, c) - num / lcm(c, a)
				+ num / lcm(a, lcm(b, c)));
	}
	
	private long gcd(long a, long b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
	
	private long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) {
		Problem1201 problem = new Problem1201();
		//System.out.println(problem.nthUglyNumber(5, 2, 11, 13));
		System.out.println(problem.nthUglyNumber(4, 2, 3, 4));
	}
}
