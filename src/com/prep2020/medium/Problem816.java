package com.prep2020.medium;
import java.util.*;
public class Problem816 {
	public List<String> ambiguousCoordinates(String s) {
		List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length() - 2; i++) {
        	List<String> l1 = findAllVariation(s.substring(1, i + 1));
        	if (l1.isEmpty()) continue;
        	List<String> l2 = findAllVariation(s.substring(i + 1, s.length() - 1));
        	if (l2.isEmpty()) continue;
        	for (String s1 : l1) {
        		for (String s2 : l2) result.add("(" + s1 + ", " + s2 + ")");
        	}
        }
        return result;
    }

	private List<String> findAllVariation(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() == 1) {
			result.add(s);
			return result;
		}
		if (s.charAt(s.length() - 1) == '0') {
			if (s.charAt(0) == '0') return result;
			result.add(s);
			return result;
		}
		if (s.charAt(0) == '0') {
			result.add("0." + s.substring(1));
			return result;
		}
		result.add(s);
		for (int i = 0; i < s.length() - 1; i++) 
			result.add(s.substring(0, i + 1) + "." + s.substring(i + 1));
		return result;
	}
	
	public static void main(String[] args) {
		Problem816 problem = new Problem816();
		System.out.println(problem.ambiguousCoordinates("(123)"));
	}
}
