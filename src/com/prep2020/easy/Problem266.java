package com.prep2020.easy;
import java.util.*;
public class Problem266 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
        	if (set.contains(c)) set.remove(c);
        	else set.add(c);
        }
        return set.size() < 2;
    }
}
