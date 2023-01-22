package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2155 {
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int maxScore = 0, leftScore = 0, rightScore = 0;
        for (int i : nums) if (i == 1) rightScore++;
        maxScore = leftScore + rightScore;
        result.add(0);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
        	if (nums[i - 1] == 0) leftScore++;
        	else rightScore--;
        	int score = leftScore + rightScore;
        	if (score > maxScore) {
        		result.clear();
        		maxScore = score;
        		result.add(i);
        	} else if (score == maxScore) result.add(i);
        }
        return result;
    }
}
