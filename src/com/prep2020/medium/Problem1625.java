package com.prep2020.medium;
import java.util.*;
public class Problem1625 {
	public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Set<String> visited = new HashSet<>();
        visited.add(s);
        String[] result = new String[] {s};
        helper(s, a, b, visited, result);
        return result[0];
    }
	
	private void helper(String s, int a, int b, Set<String> visited, String[] result) {
		if (result[0].compareTo(s) > 0) result[0] = s;
		String s1 = performAdd(s, a), s2 = rotate(s, b);
		if (!visited.contains(s1)) {
			visited.add(s1);
			helper(s1, a, b, visited, result);
		}
		if (!visited.contains(s2)) {
			visited.add(s2);
			helper(s2, a, b, visited, result);
		}
	}
	
	private String performAdd(String s, int a) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) result += s.charAt(i);
			else result += ((s.charAt(i) - '0') + a) % 10;
		}
		return result;
	}
	
	private String rotate(String s, int b) {
		return s.substring(s.length() - b) + s.substring(0, s.length() - b);
	}
}
