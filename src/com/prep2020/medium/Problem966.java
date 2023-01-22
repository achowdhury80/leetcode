package com.prep2020.medium;
import java.util.*;
public class Problem966 {
	public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        Map<String, List<String>> maskedMap = new HashMap<>();
        for (String w : wordlist) {
        	words.add(w);
        	if (!map.containsKey(w.toLowerCase()))
        		map.put(w.toLowerCase(), w);
        	String masked = "";
        	for (char c : w.toLowerCase().toCharArray()) {
        		if ("aeiou".indexOf(c) > -1) masked += "#";
        		else masked += c;
        	}
        	List<String> list = maskedMap.getOrDefault(masked, new ArrayList<>());
        	list.add(w);
        	maskedMap.put(masked, list);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	String w = queries[i];
        	if (words.contains(w)) {
        		result[i] = w;
        		continue;
        	}
        	String lower = w.toLowerCase();
        	if (map.containsKey(lower)) {
        		result[i] = map.get(lower);
        		continue;
        	}
        	
        	String masked = "";
        	for (char c : w.toLowerCase().toCharArray()) {
        		if ("aeiou".indexOf(c) > -1) masked += "#";
        		else masked += c;
        	}
        	if (maskedMap.containsKey(masked)) {
        		result[i] = maskedMap.get(masked).get(0);
        		continue;
        	}
        	result[i] = "";
        }
        return result;
    }
}
