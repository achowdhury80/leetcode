package comp.prep2019;

import java.util.Arrays;

public class Prob354 {
	/**
	 * https://leetcode.com/problems/russian-doll-envelopes/solution/
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }
	
	private int lengthOfLIS(int[] arr) {
		int[] dp = new int[arr.length];
		int len = 0;
		for (int num : arr) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) len++;
		}
		return len;
	}
}
