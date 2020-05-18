package comp.prep2019;
import java.util.*;
public class Prob1049 {
	/**
	 * dp[i][s] is whether s sum can be achieved using some of first i elements
	 * we try to find closest sum of total sum / 2.
	 * The idea is to partition the array into two parts with sum of each subsets as close to totalSum/2 to minimize the difference. Also we need to only go till sum/2 as the sum of the other subset will be totalSum - sum of subset1. Then we just see which is the closest sum possible of subset1 and return totalSum-2*possibleSum
	 * @param stones
	 * @return
	 */
	public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += stones[i];
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) dp[i][0] = true;
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
        	for (int j = 1; j <= target; j++) {
        		if (dp[i - 1][j] || j >= stones[i - 1] && dp[i-1][j - stones[i - 1]]) {
        			dp[i][j] = true;
        			result = Math.max(result, j);
        		}
        	}
        }
        return sum - 2 * result;
        
    }
}
