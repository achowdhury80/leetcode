package com.prep2020.medium;
import java.util.*;
public class Problem1772 {
	public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> count = new HashMap<>();
        for (String f : features) count.put(f, 0);
        for (String r : responses) {
        	String[] arr = r.split(" ");
        	Set<String> used = new HashSet<>();
        	for (String s : arr) {
        		if (count.containsKey(s) && used.add(s)) {
        			count.put(s, count.get(s) + 1);
        		}
        	}
        }
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < features.length; i++) indexMap.put(features[i], i);
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(count.entrySet());
        Collections.sort(entryList, (x, y) -> (x.getValue() == y.getValue() ? (indexMap.get(x.getKey()) - indexMap.get(y.getKey())) : (y.getValue() - x.getValue())));
        String[] result = new String[features.length];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : entryList) result[idx++] = entry.getKey();
        return result;
    }
}
