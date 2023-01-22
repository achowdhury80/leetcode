package com.prep2020.medium;

public class Problem1011 {
	/*
	 * O(N)
	 */
	public int shipWithinDays(int[] weights, int D) {
        int high = 0, low = 0;
        for (int w : weights) {
        	high += w;
        	low = Math.max(low, w);
        }
        int result = Integer.MAX_VALUE;
        while(high >= low) {
        	int mid = low + (high - low) / 2;
        	int d = daysTaken(weights, mid);
        	if (d <= D) {
        		result = Math.min(result, mid);
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }
	
	private int daysTaken(int[] weights, int capacity) {
		int result = 0;
		int i = 0, sum = 0;
		while(i < weights.length) {
			if (sum + weights[i] <= capacity) sum += weights[i];
			else {
				result++;
				sum = weights[i];
			}
			i++;
		}
		if (sum > 0) result++;
		return result;
	}
	
	public static void main(String[] args) {
		Problem1011 problem = new Problem1011();
		System.out.println(problem.shipWithinDays(new int[] {1,2,3,1,1}, 4));
	}
}
