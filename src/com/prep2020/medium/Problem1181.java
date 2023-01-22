package com.prep2020.medium;
import java.util.*;
public class Problem1181 {
	public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> endMap = new HashMap<>(), 
        		startMap = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
        	String[] arr = phrases[i].split(" ");
        	List<Integer> list = endMap.getOrDefault(arr[arr.length - 1], new ArrayList<>());
        	list.add(i);
        	endMap.put(arr[arr.length - 1], list);
        	list = startMap.getOrDefault(arr[0], new ArrayList<>());
        	list.add(i);
        	startMap.put(arr[0], list);
        }
        Set<String> set = new HashSet<>();
        for (String key : endMap.keySet()) {
        	if (startMap.containsKey(key)) {
        		set.addAll(findCombinations(phrases, endMap.get(key), startMap.get(key)));
        	}
        }
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
	
	private Set<String> findCombinations(String[] phrases, 
			List<Integer> starts, List<Integer> ends) {
		Set<String> set = new HashSet<>();
		for (int i : starts) {
			String[] arr1 = phrases[i].split(" ");
			for (int j : ends) {
				if (i == j) continue;
				if (phrases[j].equals(arr1[arr1.length - 1])) {
					set.add(phrases[i]);
				} else {
					set.add(phrases[i] + phrases[j].substring(arr1[arr1.length - 1].length()));
				}
				
			}
		}
		return set;
	}
}
