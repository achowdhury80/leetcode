package com.prep2020.medium;
import java.util.*;
public class Problem139 {
	/**
	 * O(N^2) time and O(N) space
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] arr = new boolean[n];
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (String w : wordDict) {
        	minLen = Math.min(minLen, w.length());
        	maxLen = Math.max(maxLen, w.length());
        	set.add(w);
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= i; j++) {
        		int len = i - j + 1;
        		if (len < minLen) break;
        		if (len > maxLen) continue;
        		if (j > 0 && !arr[j - 1]) continue;
        		if (set.contains(s.substring(j, i + 1))) arr[i] = true;
        	}
        }
        return arr[n - 1];
    }
}
