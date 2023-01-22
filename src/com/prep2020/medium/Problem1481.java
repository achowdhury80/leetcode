package com.prep2020.medium;
import java.util.*;
public class Problem1481 {
	/**
	 * O(nlogN) and O(N)
	 * @param arr
	 * @param k
	 * @return
	 */
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> values = new ArrayList<>();
        for (int val : map.values()) values.add(val);
        Collections.sort(values);
        while(k > 0) {
        	int val = values.remove(0);
        	if (val > 1) values.add(0, val - 1);
        	k--;
        }
        return values.size();
    }
}
