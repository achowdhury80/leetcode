package comp.prep2019.less1000;
import java.util.*;
public class Prob975 {
	public int oddEvenJumps(int[] A) {
		int n = A.length;
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[n - 1], n - 1);
        for (int i = n - 2; i > -1; i--) {
        	Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(A[i]);
        	Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(A[i]);
        	if (ceilingEntry != null) dp[i][0] = dp[ceilingEntry.getValue()][1];
        	if (floorEntry != null)  dp[i][1] = dp[floorEntry.getValue()][0];
        	treeMap.put(A[i], i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (dp[i][0]) result++;
        }
        return result;
    }
}
