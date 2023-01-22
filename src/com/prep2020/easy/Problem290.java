package com.prep2020.easy;
import java.util.*;
public class Problem290 {
	/**
	 * O(N) time and space
	 * @param pattern
	 * @param s
	 * @return
	 */
	public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
        	char c = pattern.charAt(i);
        	if (!map.containsKey(c)) {
        		if (map.values().contains(arr[i])) return false;
        		map.put(c, arr[i]);
        	} else if (!map.get(c).equals(arr[i])) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem290 prob = new Problem290();
		System.out.println(prob.wordPattern("abba", "dog cat cat dog"));
	}
}
