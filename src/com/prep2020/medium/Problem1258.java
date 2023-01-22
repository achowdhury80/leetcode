package com.prep2020.medium;
import java.util.*;
public class Problem1258 {
	public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> syn : synonyms) {
        	Set<String> set = null;
        	if (map.containsKey(syn.get(0))) set = map.get(syn.get(0));
        	if (map.containsKey(syn.get(1))) {
        		if (set == null) set = map.get(syn.get(1));
        		else set.addAll(map.get(syn.get(1)));
        	}
        	if (set == null) set = new HashSet<>();
        	set.add(syn.get(0));
        	set.add(syn.get(1));
        	map.put(syn.get(0), set);
        	map.put(syn.get(1), set);
        }
        List<String> result = new ArrayList<>();
        result.add("");
        String[] arr = text.split(" ");
        for (String part : arr) {
        	List<String> toBeAdded = new ArrayList<>();
        	if (map.containsKey(part)) toBeAdded.addAll(map.get(part));
        	else toBeAdded.add(part);
        	Collections.sort(toBeAdded);
        	List<String> temp = new ArrayList<>();
        	for (String s1 : result) {
        		for (String s2 : toBeAdded) {
        			if (s1.equals("")) temp.add(s2);
        			else temp.add(s1 + " " + s2);
        		}
        	}
        	result = temp;
        }
        return result;
    }
}
