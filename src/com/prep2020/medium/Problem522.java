package com.prep2020.medium;

import java.util.*;

public class Problem522 {
	public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> (a.length() == b.length() 
        		? a.compareTo(b) : b.length() - a.length()));
        Set<String> uniques = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
        	if (isSub(strs[i], uniques)) continue;
        	if ((i < strs.length - 1) && strs[i].equals(strs[i + 1])) {
        		uniques.add(strs[i]);
        		continue;
        	}
        	
        	return strs[i].length();
        }
        return -1;
    }

	private boolean isSub(String str, Set<String> uniques) {
		for (String s : uniques) {
			int i = 0, j = 0;
			while(i < str.length() && j < s.length()) {
				if (str.charAt(i) == s.charAt(j)) {
					i++;
				}
				j++;
			}
			if (i == str.length()) return true;
		}
		return false;
	}
}
