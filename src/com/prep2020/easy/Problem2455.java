package com.prep2020.easy;

public class Problem2455 {
	public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int num : nums) {
        	if (num % 6 == 0) {
        		sum += num;
        		count++;
        	}
        }
        return (int)((0. + sum) / count);
    }
}
