package com.prep2020.medium;
import java.util.*;
public class Problem1249 {
	/**
	 * O(N)
	 * two pass
	 * @param s
	 * @return
	 */
	public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndex = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == ')') {
        		count--;
        		if (count < 0) {
        			count = 0;
        			removeIndex.add(i);
        		}
        	} else if (c == '(') {
        		count++;
        	}
        }
        count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
        	char c = s.charAt(i);
        	if (c == '(') {
        		count--;
        		if (count < 0) {
        			count = 0;
        			removeIndex.add(i);
        		}
        	} else if (c == ')') {
        		count++;
        	}
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
        	if (!removeIndex.contains(i)) result += s.charAt(i);
        }
        return result;
    }
}
