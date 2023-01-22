package com.prep2020.medium;
import java.util.*;
public class Problem1593 {
	public int maxUniqueSplit(String s) {
        int[] result = new int[1];
        helper(s, new HashSet<>(), result);
        return result[0];
    }
	
	private void helper(String s, Set<String> set, int[] result) {
		if (s.length() == 0) {
			result[0] = Math.max(result[0], set.size());
			return;
		}
		
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (set.contains(sub)) continue;
			set.add(sub);
			helper(s.substring(i + 1), set, result);
			set.remove(sub);
		}
	}
}
