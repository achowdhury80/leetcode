package com.prep2020.medium;
import java.util.*;
public class Problem93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		helper(s, 0, new int[] {-1, -1, -1, -1}, 0, result);
		return result;
    }
	
	private void helper(String s, int start, int[] parts, int curPart, 
			List<String> result) {
		if (curPart == 4) {
			if (start < s.length()) return;
			result.add("" + parts[0] + "." + parts[1] + "." + parts[2] 
					+ "." + parts[3]);
			return;
		}
		int partsRemaining = 4 - curPart;
		if (partsRemaining > s.length() - start || partsRemaining * 4 
				< s.length() - start) return;
		for (int i = start; i < Math.min(i + 3, s.length()); i++) {
			if (i > start && s.charAt(start) == '0') break;
			int partVal = Integer.parseInt(s.substring(start, i + 1));
			if (partVal > 255) break;
			parts[curPart] = partVal;
			helper(s, i + 1, parts, curPart + 1, result);
			parts[curPart] = -1;
		}
	}
}
