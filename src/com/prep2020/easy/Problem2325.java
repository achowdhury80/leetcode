package com.prep2020.easy;
import java.util.*;
public class Problem2325 {
	public String decodeMessage(String key, String message) {
		Map<Character, Character> map = new HashMap<>();
		char cur = 'a';
        for (char c : key.toCharArray()) {
        	if (c == ' ' || map.containsKey(c)) continue;
        	map.put(c, cur);
        	if (map.size() == 26) break;
        	cur = (char)((int)cur + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
        	if (c == ' ') sb.append(c);
        	else sb.append(map.get(c));
        }
        return sb.toString();
    }
}
