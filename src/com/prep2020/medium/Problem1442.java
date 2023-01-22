package com.prep2020.medium;
import java.util.*;
public class Problem1442 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int xor = 0, result = 0;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0, list);
        for (int i = 0; i < arr.length; i++) {
        	xor ^= arr[i];
        	list = map.getOrDefault(xor, new ArrayList<>());
        	for (int index : list) result += (i - index - 1);
        	list.add(i);
        	map.put(xor, list);
        }
        return result;
    }
}
