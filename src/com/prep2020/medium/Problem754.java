package com.prep2020.medium;

public class Problem754 {
	public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, i = 1, result = 0;
        while(sum < target || (sum - target) % 2 != 0) {
        	result++;
        	sum += i;
        	i++;
        }
        return result;
    }
}
