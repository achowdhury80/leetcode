package comp.prep2019;
import java.util.*;
public class Prob446 {
	public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        int result = 0;
        for (int i = 1; i < n; i++) {
        	for (int j = i - 1; j > -1; j--) {
        		long delta = (long)A[i] - (long)A[j];
        		if (delta > Integer.MAX_VALUE || delta < Integer.MIN_VALUE) continue;
        		int diff = (int) delta;
        		Map<Integer, Integer> countMap = dp[j];
        		int sum = dp[j].getOrDefault(diff, 0), 
        				origin = dp[i].getOrDefault(diff, 0);
        		dp[i].put(diff, sum + origin + 1);
        		result += sum;
        	}
        }
        return result;
    }
}
