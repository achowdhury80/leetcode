package com.prep2020.easy;
import java.util.*;
public class Problem819 {
	public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) set.add(s.toLowerCase());
        Map<String, Integer> map = new HashMap<>();
        String last = "";
        for (char c : paragraph.toCharArray()) {
        	c = Character.toLowerCase(c);
        	if (c >= 'a' && c <='z') {
        		last += c;
        	} else {
        		if (!last.equals("") && !set.contains(last)) map.put(last, map.getOrDefault(last, 0) + 1);
        		last = "";
        	}
        }
        if (!last.equals("")) map.put(last, map.getOrDefault(last, 0) + 1);
        int count = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	if (entry.getValue() > count) {
        		result = entry.getKey();
        		count = entry.getValue();
        	}
        }
        return result;
    }
}
