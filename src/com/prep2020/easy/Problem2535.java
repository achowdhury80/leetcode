package com.prep2020.easy;

public class Problem2535 {
	public int differenceOfSum(int[] nums) {
        int result = 0;
        for (int num : nums) {
        	if (num < 10) continue;
        	result += num;
        	while(num > 0) {
        		result -= num % 10;
        		num /= 10;
        	}
        }
        return result;
    }
}
