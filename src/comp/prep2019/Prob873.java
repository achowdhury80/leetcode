package comp.prep2019;
import java.util.*;
public class Prob873 {
	public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int n;
        for (int i = 0; i < (n = A.length); i++) map.put(A[i], i);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		int target = A[j] - A[i];
        		int index = map.getOrDefault(target, -1);
        		dp[i][j] = 2;
        		if (index > -1) {
        			dp[i][j] = Math.max(dp[i][j], 1 + dp[index][i]);
        		}
        		result = Math.max(result, dp[i][j]);
        	}
        }
        if (result < 3) return 0;
        return result;
    }
}