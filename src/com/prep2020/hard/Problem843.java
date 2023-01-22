package com.prep2020.hard;
import java.util.*;
public class Problem843 {
	public void findSecretWord(String[] words, Master master) {
		int n = words.length;
		Map<String, Map<Integer, Set<String>>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		int match = compare(words[i], words[j]);
        		if (match == 0) continue;
        		Map<Integer, Set<String>> map1 = map.getOrDefault(words[i], new HashMap<>());
            	map.put(words[i], map1);
            	Set<String> set1 = map1.getOrDefault(match, new HashSet<>()); 
            	map1.put(match, set1);
            	set1.add(words[j]);
            	
            	Map<Integer, Set<String>> map2 = map.getOrDefault(words[j], new HashMap<>());
            	map.put(words[j], map2);
            	Set<String> set2 = map2.getOrDefault(match, new HashSet<>()); 
            	map2.put(match, set2);
            	set2.add(words[i]);
        	}
        }
        Set<String> visited = new HashSet<>();
        for (String s : words) {
        	if (visited.contains(s)) continue;
        	int match = master.guess(s);
        	if (match == 6) return;
        	visited.add(s);
        	if (master.guess(s) > 0) {
        		if (search(s, map, visited, master, match)) return;
        	}
        }
    }
	
	private boolean search(String s, Map<String, Map<Integer, Set<String>>> map, Set<String> visited, Master master,
			int match) {
		Set<String> set = map.get(s).get(match);
		for (String str : set) {
			if (visited.contains(str)) continue;
			int m = master.guess(str);
			if (m == 6) return true;
			visited.add(str);
			if (search(str, map, visited, master, m)) return true;
		}
		return false;
	}

	private int compare(String s1, String s2) {
		int result = 0;
		for (int i = 0; i < 6; i++) {
			if (s1.charAt(i) == s2.charAt(i)) result++;
		}
		return result;
	}

	interface Master {
		      public int guess(String word);
		  }
}
