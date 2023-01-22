package com.prep2020.medium;
import java.util.*;
public class Problem1062 {
	/**
	 * O(nlogn) time 
	 * O(N^2) space
	 * @param s
	 * @return
	 */
	public int longestRepeatingSubstring(String S) {
        int l = 1, r = S.length();
        int result = 0;
        while(l <= r) {
        	int mid = l + (r - l) / 2;
        	Set<String> set = new HashSet<>();
        	for (int i = 0; i + mid - 1 < S.length(); i++) {
        		String sub = S.substring(i, i + mid);
        		if (set.contains(sub)) {
        			result = sub.length();
        			break;
        		} else set.add(sub);
        	}
        	if (result == mid) l = mid + 1;
        	else r = mid - 1;
        }
        return result;
    }
}
