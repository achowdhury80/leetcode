package com.prep2020.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem893 {
	/**
	 * o(s.length * s[i].length) time and space
	 * group even characters, assemble them in sorted order
	 * do the same for odd characters
	 * put it in set
	 * @param A
	 * @return
	 */
	public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
        	String[] even = new String[26], odd = new String[26];
        	for (int i = 0; i < s.length(); i++) {
        		char c = s.charAt(i);
        		if (i % 2 == 0) {
        			even[c - 'a'] = (even[c - 'a'] == null ? "" : even[c - 'a']) + c;
        		}
        		else {
        			odd[c - 'a'] = (odd[c - 'a'] == null ? "" : odd[c - 'a']) + c;
        		}
        	}
        	String str = "";
        	for (int i = 0; i < 26; i++) {
        		if (even[i] != null) str += even[i];
        	}
        	for (int i = 0; i < 26; i++) {
        		if (odd[i] != null) str += odd[i];
        	}
        	set.add(str);
        }
        return set.size();
    }
}
