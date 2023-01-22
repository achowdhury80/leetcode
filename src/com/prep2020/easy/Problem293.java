package com.prep2020.easy;
import java.util.*;
public class Problem293 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') 
				result.add(s.substring(0, i) + "--" + s.substring(i + 2));
		}
		return result;
    }
}
