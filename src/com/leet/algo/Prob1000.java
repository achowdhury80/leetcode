package com.leet.algo;

public class Prob1000 {
	/**
	 * https://leetcode.com/problems/minimum-cost-to-merge-stones/discuss/331563/Java-solution-with-explanation
	 * @param stones
	 * @param K
	 * @return
	 */
	public int mergeStones(int[] stones, int K) {
		int len = stones.length;
		
		// finding if the input can be merged
		if((len - 1) % (K-1) > 0) {
			return -1;
		}
		
		int[] sumArr = new int[len + 1];
		
		// finding the summation of the stones  
		for(int i=1; i<=len; i++) {
			sumArr[i] = sumArr[i-1] + stones[i-1];
		}
		
		// taking a bottom up DP approach where each entry represents the min cost for each sub array
		int[][] dp = new int[len][len];
		
		for(int span = K; span<=len; span++) {
			for(int left = 0; left + span <= len; left ++) {
				int right = left + span - 1; // since width is 1 based 
				
				dp[left][right] = Integer.MAX_VALUE;
				
				for(int split = left; split < right; split += (K-1)) { // since K is 1 based and we can merge only K piles. 
					dp[left][right] = Math.min(dp[left][right], dp[left][split] + dp[split + 1][right]);
				}
				
				// take e.g. Stones = [1,2,3,4,5] and K = 3
				// when span = 5th index, left = 0th index, right = 4th index and split = 2nd index
				// dp for subarray [1,2,3] will return 6 and for subarray [4,5] it will be 0
				// this will make dp[left][right] as 6 + 0 = 6;
				// so visually the given array will be represented from [1,2,3,4,5] to [([1,2,3] merged to 6), 4, 5]
				// we should merge [6,4,5] as well. This computation is being achieved in the logic below.
				if((left - right) % (K-1) == 0) {
					dp[left][right] += (sumArr[right + 1] - sumArr[left]);
				}
			}
		}
		
		return dp[0][len - 1];       
    }
}
