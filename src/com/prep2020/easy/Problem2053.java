package com.prep2020.easy;
import java.util.*;
public class Problem2053 {
	/**
	 * O(N)
	 * @param arr
	 * @param k
	 * @return
	 */
	public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> map = new HashMap<>();
        for (String w : arr) {
        	if (map.containsKey(w)) map.put(w, false);
        	else map.put(w, true);
        }
        int distinctCount = 0;
        for (String w : arr) {
        	if (map.get(w)) {
        		distinctCount++;
        		if (distinctCount == k) return w;
        	}
        }
        return "";
    }
}
