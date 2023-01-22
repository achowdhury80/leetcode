package com.prep2020.medium;
import java.util.*;
public class Problem49 {
	/**
	 * O(N) time and space
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
        	char[] arr = w.toCharArray();
        	Arrays.sort(arr);
        	String key = new String(arr);
        	List<String> list = map.getOrDefault(key, new ArrayList<>());
        	list.add(w);
        	map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) result.add(list);
        return result;
    }
}
