package comp.prep2019;
import java.util.*;
public class Prob1027 {
	/**
	 * dp[i][diff] = taking the element i, what is the max number of elements before with diff
	 * @param A
	 * @return
	 */
	public int longestArithSeqLength(int[] A) {
		int n;
        Map<Integer, Integer>[] dp = new HashMap[(n = A.length)];
        dp[0] = new HashMap<>();
        dp[0].put(0, 1);
        int result = 0;
        for (int i = 1; i < n; i++) {
        	for (int j = i - 1; j > -1; j--) {
        		int diff = A[i] - A[j];
        		int count = dp[j].getOrDefault(diff, 1) + 1;
        		if (dp[i] == null) dp[i] = new HashMap<>();
        		dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), count));
        		result = Math.max(result, dp[i].get(diff)); 
        	}
        }
        return result;
    }
}
