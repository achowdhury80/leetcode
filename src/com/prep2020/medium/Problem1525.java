package com.prep2020.medium;
import java.util.*;
public class Problem1525 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public int numSplits(String s) {
        int n = s.length();
        // arr[i] denotes number of distinct character in s starting from index i till end
        int[] arr = new int[n];
        Set<Character> set = new HashSet<>();
        for (int i = n - 1; i > -1; i--) {
        	set.add(s.charAt(i));
        	arr[i] = set.size();
        }
        int result = 0;
        set.clear();
        for (int i = 0; i < n - 1; i++) {
        	set.add(s.charAt(i));
        	if (set.size() == arr[i + 1]) result++;
        	if (set.size() > arr[i + 1]) break;
        }
        return result;
    }
}
