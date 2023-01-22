package com.prep2020.hard;

import java.util.Arrays;

public class Problem1402 {
	/**
	 * O(NLogN)
	 * sort data
	 * find result without discarding
	 * then keep on deleting from first. To get quicker result, maintain array of sum starting ith element
	 * @param satisfaction
	 * @return
	 */
	public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int result = 0, sum = 0;
        int[] arr = new int [satisfaction.length];
        arr[satisfaction.length - 1] = satisfaction[satisfaction.length - 1];
        sum += satisfaction[satisfaction.length - 1] * satisfaction.length;
        for (int i = satisfaction.length - 2; i > -1; i--) {
        	arr[i] = arr[i + 1] + satisfaction[i];
        	sum += (i + 1) * satisfaction[i];
        }
        result = Math.max(result, sum);
        for (int i = 0; i < arr.length; i++) {
        	sum -= arr[i];
        	result = Math.max(result, sum);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1402 problem = new Problem1402();
		System.out.println(problem.maxSatisfaction(new int[] {-1, -8, 0, 5, -7}));
	}
}
