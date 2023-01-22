package com.prep2020.easy;
import java.util.*;
public class Problem811 {
	/**
	 * O(N * w) where w is the count of periods
	 * @param cpdomains
	 * @return
	 */
	public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
        	String[] arr = s.split(" ");
        	int count = Integer.parseInt(arr[0]);
        	map.put(arr[1], map.getOrDefault(arr[1], 0) + count);
        	int idx;
        	while((idx = arr[1].indexOf('.')) > -1) {
        		arr[1] = arr[1].substring(idx + 1);
        		map.put(arr[1], map.getOrDefault(arr[1], 0) + count);
        	}
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	result.add("" + entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
