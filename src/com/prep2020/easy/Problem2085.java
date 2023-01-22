package com.prep2020.easy;
import java.util.*;
public class Problem2085 {
	/**
	 * O(N) time and space
	 * @param words1
	 * @param words2
	 * @return
	 */
	public int countWords(String[] words1, String[] words2) {
        Map<String, Boolean> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (String w : words1) {
        	if (map1.containsKey(w)) map1.put(w, false);
        	else map1.put(w, true);
        }
        for (String w : words2) {
        	if (map2.containsKey(w)) map2.put(w, false);
        	else map2.put(w, true);
        }
        int result = 0;
        for (String w : map1.keySet()) {
        	if (map1.get(w) && map2.getOrDefault(w, false)) result++;
        }
        return result;
    }
}
