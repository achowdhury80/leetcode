package comp.prep2019;
import java.util.*;
public class Prob1187 {
	/**
	 * https://leetcode.com/problems/make-array-strictly-increasing/discuss/602908/Java-O(mnlogm)-DP-solution
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr2) set.add(i);
        int[][] dp = new int[arr1.length][arr1.length + 1];
        for (int i = 0; i < dp.length; i++) {
        	for (int j = 0; j < dp[0].length; j++) {
        		dp[i][j] = -1;
        	}
        }
        dp[0][0] = arr1[0];
        Integer higher;
        if ((higher = set.higher(-1)) != null && higher < arr1[0]) dp[0][1] = higher;
        for (int i = 1; i < arr1.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		int last = dp[i - 1][j];
        		int current = arr1[i];
        		if (last == - 1) continue;
        		higher = set.higher(last);
        		if (current <= last) {
        			if (higher != null) dp[i][j + 1] = higher;
        		} else {
        			if (higher != null && higher < current) {
        				dp[i][j + 1] = higher;
        			}
        			if (dp[i][j] > -1) dp[i][j] = Math.min(dp[i][j], current);
        			else dp[i][j] = current;
        		}
        	}
        }
        for (int i = 0; i < dp[0].length; i++) {
        	if (dp[dp.length - 1][i] > - 1) return i;
        }
        return -1;
    }
}
