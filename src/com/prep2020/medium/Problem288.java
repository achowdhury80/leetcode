package com.prep2020.medium;
import java.util.*;
public class Problem288 {
	private Map<String, Set<String>> map;
	public Problem288(String[] dictionary) {
        this.map = new HashMap<>();
        for (String w : dictionary) {
        	String abbr = findAbbr(w);
        	Set<String> set = map.getOrDefault(abbr, new HashSet<>());
        	set.add(w);
        	map.put(abbr, set);
        }
    }
    
    public boolean isUnique(String word) {
    	String abbr = findAbbr(word);
    	return !map.containsKey(abbr) || (map.get(abbr).size() == 1 
    			&& map.get(abbr).contains(word));
    }
    
    private String findAbbr(String s) {
    	if (s.length() < 3) return s;
    	return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
}
