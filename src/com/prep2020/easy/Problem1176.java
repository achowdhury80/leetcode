package com.prep2020.easy;

public class Problem1176 {
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < calories.length; i++) {
        	sum += calories[i];
        	if (i < k - 1) continue;
        	if (i >= k) sum -= calories[i - k];
        	if (sum < lower) result--;
        	else if (sum > upper) result++;
        }
        return result;
    }
}
