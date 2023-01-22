package com.prep2020.hard;
import java.util.*;
public class Problem761 {
	public String makeLargestSpecial(String s) {
        return helper(s, 0, s.length() - 1); 
    }
	
	private String helper(String s, int start, int end) {
		if (start > end) return "";
		int bal = 0;
		int groupStart = 0;
		List<String> subGroups = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			bal += (s.charAt(i) == '1' ? 1 : -1);
			if (bal == 0) {
				subGroups.add("1" + helper(s, start + 1, i - 1) + "0");
				start = i + 1;
			}
		}
		Collections.sort(subGroups, (x, y) -> y.compareTo(x));
		StringBuilder sb = new StringBuilder();
		for (String st : subGroups) {
			sb.append(st);
		}
		return sb.toString();
	}
}
