package com.leet.algo;

public class Prob1011 {
	public int shipWithinDays(int[] weights, int D) {
		int sum = 0, max = 0;
		for (int w : weights) {
			sum += w;
			max = Math.max(max, w);
		}
		int start = max, end = sum;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (getTimeSpent(weights, mid) <= D) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
    }
	
	private int getTimeSpent(int[] weights, int capacity) {
		int result = 0;
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
			if (sum >= capacity) {
				sum -= capacity;
				if (sum > 0) sum = weights[i];
				result++;
			}
		}
		if (sum > 0) result++;
		return result;
	}
	
	public static void main(String[] args) {
		Prob1011 prob = new Prob1011();
		System.out.println(prob.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
	}
}
