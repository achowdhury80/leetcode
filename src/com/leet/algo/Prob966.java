package com.leet.algo;
import java.util.*;
public class Prob966 {
	public String[] spellchecker(String[] wordlist, String[] queries) {
		Map<String, List<String>> map = new HashMap<>();
        for (String w : wordlist) {
        	String lower = w.toLowerCase();
        	if (!map.containsKey(lower)) map.put(lower, new ArrayList<>());
        	map.get(lower).add(w);
        	StringBuilder sb = new StringBuilder();
        	boolean replaced = false;
        	for (char c : lower.toCharArray()) {
        		if ("aeiou".indexOf(c) > -1) {
        			sb.append("_");
        			replaced = true;
        		} else sb.append(c);
        	}
        	if (replaced) {
        		if (!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList<>());
        		map.get(sb.toString()).add(w);
        	}
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	result[i] = "";
        	String q = queries[i].toLowerCase();
        	if (map.containsKey(q)) {
        		result[i] = map.get(q).get(0);
        		for (String s : map.get(q)) {
        			if (s.equals(queries[i])) {
        				result[i] = s;
        				break;
        			}
        		}
        		
        	}
        	else {
        		StringBuilder sb = new StringBuilder();
        		for (char c : q.toCharArray()) {
            		if ("aeiou".indexOf(c) > -1) {
            			sb.append("_");
            		} else sb.append(c);
            	}
        		if (map.containsKey(sb.toString())) result[i] = map.get(sb.toString()).get(0);
        	}
        }
        return result;
    }
}