package com.prep2020.medium;
import java.util.*;
public class Problem1807 {
	/**
	 * O(N) time and space
	 * @param s
	 * @param knowledge
	 * @return
	 */
	public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
        	map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '(') start = i;
        	else if (c == ')') {
        		String key = s.substring(start + 1, i);
        		if (map.containsKey(key)) sb.append(map.get(key));
        		else sb.append("?");
        		start = -1;
        	} else if (start == -1) {
        		sb.append(c);
        	}
        }
        return sb.toString();
    }
}
