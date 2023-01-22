package com.prep2020.easy;

public class Problem1295 {
	public int findNumbers(int[] nums) {
		int result = 0;
		for (int num : nums) {
			if (num > 9 & num < 100) result++;
			else if (num > 999 && num < 10000) result++;
			else if (num == 100000) result++;
		}
		return result;
    }
}
