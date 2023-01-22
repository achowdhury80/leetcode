package com.prep2020.medium;

import java.util.*;

public class Problem826 {
	/**
	 * O(nlogN)
	 * @param difficulty
	 * @param profit
	 * @param worker
	 * @return
	 */
	public int maxProfitAssignment(int[] difficulty, int[] profit, 
			int[] worker) {
		int n = profit.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> difficulty[x] - difficulty[y]);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxProfit = -1;
        for (int i : arr) {
        	int curdiff = difficulty[i];
        	maxProfit = Math.max(maxProfit, profit[i]);
        	treeMap.put(curdiff, maxProfit);
        }
        int result = 0;
        for (int w : worker) {
        	Map.Entry<Integer, Integer> entry = treeMap.floorEntry(w);
        	if (entry != null) result += entry.getValue();
        }
        return result;
    }
}
