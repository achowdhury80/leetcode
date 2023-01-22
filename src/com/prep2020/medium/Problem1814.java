package com.prep2020.medium;
import java.util.*;
public class Problem1814 {
	public int countNicePairs(int[] nums) {
        long mod = (long)(1e9 + 7);
        Map<Long, Long> map = new HashMap<>();
        for (int n : nums) {
        	int rev = findRev(n);
        	long diff = rev - n;
        	map.put(diff, map.getOrDefault(diff, 0l) + 1);
        }
        long result = 0;
        for (long key : map.keySet()) {
        	long count = map.get(key);
        	result = (result + ((count * (count - 1)) / 2) % mod) % mod;
        }
        return (int)result;
    }
	
	private int findRev(int n) {
		if (n == 0) return n;
		int result = 0;
		while(n > 0) {
			result = result * 10 + n % 10;
			n /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1814 problem = new Problem1814();
		System.out.println(problem.countNicePairs(new int[] {42, 11, 1, 97}));
	}
}
