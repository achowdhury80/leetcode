package com.prep2020.medium;

import java.util.*;

public class Problem1048 {
	/**
	 * O(N) space
	 * Amortized O(N) time
	 * @param words
	 * @return
	 */
	public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        int result = 1;
        // start of each sized word
        Map<Integer, Integer> map = new HashMap<>();
        // length of longest chain including that word
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
        	int len = words[i].length();
        	if(!map.containsKey(len)) map.put(len, i);
        	arr[i] = 1;
        	if (!map.containsKey(len - 1)) continue;
        	for (int j = map.get(len - 1); j < map.get(len); j++) {
        		if (follows(words[j], words[i])) arr[i] = Math.max(arr[i], 1 + arr[j]);
        	}
        	result = Math.max(result, arr[i]);
        }
        return result;
    }

	private boolean follows(String w1, String w2) {
		boolean flag = true;
		for (int i = 0, j = 0; i < w1.length(); i++, j++) {
			if (w1.charAt(i) == w2.charAt(j)) continue;
			if (!flag) return false;
			flag = false;
			i--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem1048 problem = new Problem1048();
		System.out.println(problem.longestStrChain(new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"}));
	}
}
