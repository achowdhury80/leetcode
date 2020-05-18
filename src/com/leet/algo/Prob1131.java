package com.leet.algo;
import java.util.*;
/**
 * https://leetcode.com/problems/maximum-of-absolute-value-expression/discuss/340075/c%2B%2B-beats-100-(both-time-and-memory)-with-algorithm-and-image
 * @author aychowdh
 *
 */
public class Prob1131 {
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        List<Integer> 
        	sum1 = new ArrayList<>(),
        	diff1 = new ArrayList<>(),
        	sum2 = new ArrayList<>(),
        	diff2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	sum1.add(arr1[i] + arr2[i] + i);
        	diff1.add(arr1[i] - arr2[i] + i);
        	sum2.add(arr1[i] + arr2[i] - i);
        	diff2.add(arr1[i] - arr2[i] - i);
        }
        return Math.max(Math.max(findMaxDiff(sum1), findMaxDiff(diff1)), 
        		Math.max(findMaxDiff(sum2), findMaxDiff(diff2)));
    }
	
	private int findMaxDiff(List<Integer> list) {
		int maxSum = list.get(0), minSum = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			maxSum = Math.max(maxSum, list.get(i));
			minSum = Math.min(minSum, list.get(i));
		}
		return maxSum - minSum;
		
	}
}
