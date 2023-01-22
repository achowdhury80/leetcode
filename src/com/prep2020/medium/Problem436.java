package com.prep2020.medium;
import java.util.*;
public class Problem436 {
	/**
	 * O(nLogn)
	 * @param intervals
	 * @return
	 */
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
        	treeMap.put(intervals[i][0], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
        	Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
        	if (entry == null) result[i] = -1;
        	else result[i] = entry.getValue();
        }
        return result;
    }
}
