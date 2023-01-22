package com.prep2020.medium;

public class Problem1423 {
	/**
	 * O(N)
	 * @param cardPoints
	 * @param k
	 * @return
	 */
	public int maxScore(int[] cardPoints, int k) {
        int sum = 0, minScore = Integer.MAX_VALUE, n = cardPoints.length, curScore = 0;
        int len = n - k;
        for (int i = 0; i < cardPoints.length; i++) {
        	curScore += cardPoints[i];
        	sum += cardPoints[i];
        	if (i >= len) curScore -= cardPoints[i - len];
        	if (i > len - 2) minScore = Math.min(minScore, curScore);
        }
        return sum - minScore;
    }
}
