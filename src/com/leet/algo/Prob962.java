package com.leet.algo;

public class Prob962 {

	/*
	 * Not exactly “find” for every index, rather consider. The problem is to find maximum of all such distances, so trick is that for many indices, we can eliminate that calculation.

For 6 0 8 2 1 5, when I know that for 0, right end of the ramp (let’s call it idx2) is 5, I needn’t calculate it for numbers occurring between 0 and 5 for the case of idx2=5, since their distance to 5 would anyways be less than the one between 0 to 5.

Classical two pointer problem. Right pointer expands the range and left pointer contracts it. The trick is that left pointer iterates over original array and right pointer iterates over an array which stores maximum no. on the right for each index.
O(n)
	 */
	public int maxWidthRamp(int[] A) {
		int n = A.length;
        int[] rMax = new int[n];
        rMax[n -1] = A[n - 1];
        for (int i = n - 2; i > -1; i--) rMax[i] = Math.max(rMax[i + 1], A[i]);
        int left = 0, right = 0, result = 0;
        while(right < n) {
        	while(left < right && A[left] > rMax[right]) left++;
        	result = Math.max(result, right - left);
        	right++;
        }
        return result;
    }
	
}
