package com.prep2020.medium;
import java.util.*;

public class Problem1770 {
	// In general, a unique DP state is defined by the index of item in multipliers array and the current
    // left and right index in nums array. SO, we need 3D matrix. But, we can see that we can determinstically
    // calculate the third dimension, if we have any of the two other values.
    // So, in reality, only two dimensions are independent and so, we use that only.

    // row is #num of items we have consumed from left side of array nums.
    // col is #num of items we have consumed from right side of array nums.
    // From, row and col, we can get what item is currently active in multiplier array. It is -> (row + col)th item.

    // dp[left][right] = max Score, we can get using #left operation and #right operation.
    // ans is the max{dp[left][right]} where left + right = m.
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;

        int[][] dp = new int[m+1][m+1];
        dp[0][0] = 0;
        int result = Integer.MIN_VALUE;
        for(int left = 0; left <= m; ++left) {
            for (int right = 0; right <= m; right++) {
                int index = right + left -1;
                if (index < 0 || index >= m)
                    continue;
                
                if (left == 0) {
                    dp[left][right] = dp[left][right -1] + nums[nums.length - right] * multipliers[index];
                } else if (right == 0) {
                    dp[left][right] = dp[left -1][right] + nums[left -1] * multipliers[index];
                } else {
                    int a = dp[left -1][right] + nums[left -1] * multipliers[index];
                    int b = dp[left][right -1] + nums[nums.length - right] * multipliers[index];
                    dp[left][right] = Math.max(a, b);
                }
                
                if (index == m-1) {
                    result = Math.max(result, dp[left][right]);
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1770 problem = new Problem1770();
		System.out.println(problem.maximumScore(new int[] {1, 2, 3}, new int[] {3, 2, 1}));
	}
}
