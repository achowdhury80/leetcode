package com.prep2020.medium;
import java.util.*;
public class Problem1424 {
	/**
	 * O(n) n = number of elements
	 * @param nums
	 * @return
	 */
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0, m = nums.size(), n = 0;
        for (int i = 0; i < m; i++) {
        	List<Integer> row = nums.get(i);
        	n = Math.max(n, row.size());
        	for (int j = 0; j < row.size(); j++) {
        		List<Integer> list = map.getOrDefault(i + j, new ArrayList<>());
        		list.add(0,row.get(j));
        		map.put(i + j, list);
        		count++;
        	}
        }
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < m + n - 1; i++) {
        	List<Integer> list = map.getOrDefault(i, new ArrayList<>());
        	for (int j = 0; j < list.size(); j++) result[idx++] = list.get(j);
        }
        return result;
    }
}
