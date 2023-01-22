package com.prep2020.medium;

public class Problem875 {
	/**
	 * O(nLog(maxPile))
	 * @param piles
	 * @param h
	 * @return
	 */
	public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int p : piles) {
        	high = Math.max(high, p);
        }
        int result = low;
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	if (timeTaken(piles, mid) <= h) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }
	
	private int timeTaken(int[] piles, int count) {
		int result = 0;
		for (int p : piles) {
			if (p <= count) result++;
			else result += p / count + (p % count > 0 ? 1 : 0);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem875 problem = new Problem875();
		System.out.println(problem.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
	}
}
