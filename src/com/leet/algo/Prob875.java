package com.leet.algo;

public class Prob875 {
	public int minEatingSpeed(int[] piles, int H) {
        long sum = 0;
        int max = -1;
        for (int i = 0; i < piles.length; i++) {
        	sum += piles[i];
        	max = Math.max(max, piles[i]);
        }
        long start = 1;
        if (sum > H) {
        	start = (sum / H);
        	if (sum % H != 0) start++;
        }
        if (start < 1) start = 1;
        long end = sum;
        while (start + 1 < end) {
        	long mid = start + (end - start) / 2;
        	if (timeSpent(piles, mid) <= H) end = mid;
        	else start = mid;
        }
        return (int)(timeSpent(piles, start) <= H ? start : end);
        
    }
	
	private int timeSpent(int[] piles, long k) {
		int result = 0;
		for (int i = 0; i < piles.length; i++) {
			result += (piles[i] - 1) / k + 1;
		}
		return result;
	}
}
