package com.prep2020.medium;
import java.util.*;
public class Problem1930 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int countPalindromicSubsequence(String s) {
		int n = s.length();
		// each char first and last position
		int[][] arr = new int[26][];
		for (int i = 0; i < 26; i++) arr[i] = new int[] {-1, -1};
        for (int i = 0; i < n; i++) {
        	int idx = s.charAt(i) - 'a';
        	if (arr[idx][0] == -1) arr[idx][0] = i;
        	arr[idx][1] = i;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
        	if (arr[i][0] == arr[i][1]) continue;
        	Set<Integer> set = new HashSet<>();
        	for (int j = arr[i][0] + 1; j < arr[i][1]; j++) 
        		set.add(s.charAt(j) - 'a');
        	result += set.size();
        }
        return result;
	}
}
