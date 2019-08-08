package com.leet.algo;

public class Prob327 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		if (n == 0) return 0;
        long[] preSum = new long[n + 1];
        //compute preSum
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        //divide n Concur
        // check left is 0 not 1. our valid preSum starts at 1
        return mergeNCount(preSum, 0, n, lower, upper);
        
    }
	
	private int mergeNCount(long[] preSum, int left, int right, int lower, int upper) {
		if (left >= right) return 0;
		int mid = left + (right - left) / 2;
		int result = mergeNCount(preSum, left, mid, lower, upper) 
				+ mergeNCount(preSum, mid + 1, right, lower, upper);
		for (int i = left, k = mid + 1, j = mid + 1; i <= mid; i++) {
			// move k to the index where preSum[k] - preSum[i] >= lower
			while (k <=right && preSum[k] - preSum[i] < lower) k++;
			//  move k to the index where preSum[j] - preSum[i] > upper
			while(j <= right && preSum[j] - preSum[i] <= upper) j++;
			result += (j - k);
		}
		// merge sort. At this point we don't care about the preSum order.
		// we sort to make it easier for next bigger merge and count
		merge(preSum, left, mid, right);
		return result;
	}
	
	private void merge(long[] preSum, int left, int mid, int right) {
		long[] leftA = new long[mid + 1 - left];
        long[] rightA = new long[right - mid];
        for(int i = left; i <= mid; i++){
            leftA[i - left] = preSum[i];
        }
        for(int i = mid + 1; i <= right; i++){
            rightA[i - mid -1] = preSum[i];
        }
        int p = 0, q = 0;
        for (int i = left; i <= right; i++) {
        	if (p < leftA.length && q < rightA.length) {
        		if (leftA[p] <= rightA[q]) preSum[i] = leftA[p++];
        		else preSum[i] = rightA[q++];
        	}
        	else if (p < leftA.length) preSum[i] = leftA[p++];
        	else preSum[i] = rightA[q++];
        }
	}
	
	public static void main(String[] args) {
		Prob327 prob = new Prob327();
		System.out.println(prob.countRangeSum(new int[] {-2, 5, -1}, -2, 2));
	}
}
