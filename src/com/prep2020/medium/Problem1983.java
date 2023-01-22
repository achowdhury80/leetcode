package com.prep2020.medium;
import java.util.*;
public class Problem1983 {
	/**
	 * O(N) time and space
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        diffMap.put(0, -1);
        int curDiff = 0;
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
        	curDiff += nums1[i] - nums2[i];
        	int prevIndex = diffMap.getOrDefault(curDiff, -2);
        	if (prevIndex == -2) diffMap.put(curDiff, i);
        	else result = Math.max(result, i - prevIndex);
        }
        return result;
    }
}
