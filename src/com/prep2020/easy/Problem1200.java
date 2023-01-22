package com.prep2020.easy;
import java.util.*;
public class Problem1200 {
	/**
	 * O(NlogN)
	 * @param arr
	 * @return
	 */
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
        	int diff = arr[i] - arr[i - 1];
        	if (diff < minDiff) {
        		result.clear();
        		minDiff = diff;
        		result.add(Arrays.asList(arr[i - 1], arr[i]));
        	} else if (diff == minDiff) {
        		result.add(Arrays.asList(arr[i - 1], arr[i]));
        	}
        }
        return result;
    }
}
