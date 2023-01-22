package com.prep2020.medium;
import java.util.*;
public class Problem673 {
	/**
	 * O(n^2)
	 * @param nums
	 * @return
	 */
	public int findNumberOfLIS(int[] nums) {
		if (nums.length < 1) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[] {1, 1};
        int[] result = new int[] {1, 1};
        for (int i = 1; i < nums.length; i++) {
        	dp[i] = new int[] {1, 1};
        	for (int j = i - 1; j > -1; j--) {
        		if (nums[j] < nums[i]) {
        			if (1 + dp[j][0] > dp[i][0]) {
        				dp[i] = new int[] {1 + dp[j][0], dp[j][1]};
        			} else if (1 + dp[j][0] == dp[i][0]) {
        				dp[i][1] += dp[j][1];
        			}
        		}
        	}
        	if (result[0] < dp[i][0]) {
        		result[0] = dp[i][0];
        		result[1] = dp[i][1];
        	} else if (result[0] == dp[i][0]) result[1] += dp[i][1];
        }
        return result[1];
    }
	
	
	public static void main(String[] args) {
		Problem673 problem = new Problem673();
		/*System.out.println(problem.findNumberOfLIS(new int[] {1, 3, 5, 4, 
				7}));*/
		System.out.println(problem.findNumberOfLIS(new int[] {1, 2, 4, 3, 
				5, 4, 7, 2}));
	}
}
