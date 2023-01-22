package com.prep2020.medium;

public class Problem1395 {
	/**
	 * O(N^2)
	 * @param rating
	 * @return
	 */
	public int numTeams(int[] rating) {
        int n = rating.length, result = 0;
        if (n < 3) return 0;
        for (int i = 1; i < n - 1; i++) {
        	int leftLarger = 0, leftSmaller = 0, rightLarger = 0, rightSmaller = 0;
        	for (int j = 0; j < i; j++) {
        		if (rating[j] < rating[i]) leftSmaller++;
        		else leftLarger++;
        	}
        	
        	for (int j = i + 1; j < rating.length; j++) {
        		if (rating[j] < rating[i]) rightSmaller++;
        		else rightLarger++;
        	}
        	result += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }
        
        return result;
    }
}
