package com.prep2020.medium;

import java.util.Arrays;

public class Problem1170 {
	/**
	 * O(NlogN)
	 * @param queries
	 * @param words
	 * @return
	 */
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) arr[i] = fsValue(words[i]);
        Arrays.sort(arr);
        for (int i = 0; i < queries.length; i++) {
        	int fsVal = fsValue(queries[i]);
        	result[i] = findNumberOfWordsWithSmallerFs(arr, fsVal);
        }
        return result;
    }
	
	private int findNumberOfWordsWithSmallerFs(int[] arr, int fsVal) {
		int low = 0, high = arr.length - 1;
		while(low < high) {
			int mid = low + (high - low) / 2;
			if (fsVal < arr[mid]) high = mid;
			else low = mid + 1;
		}
		if (arr[low] > fsVal) return arr.length - low;
		return 0;
	}

	private int fsValue(String s) {
		char lowest = 'z';
		int[] arr = new int[26];
		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
			if (lowest > c) lowest = c;
		}
		return arr[lowest - 'a'];
	}
	
	public static void main(String[] args) {
		Problem1170 problem = new Problem1170();
		//int[] result = problem.numSmallerByFrequency(new String[]{"cbd"}, new String[] {"zaaaz"});
		int[] result = problem.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[] {"a", "aa", "aaa", "aaaa"});
		System.out.println(result);
	}
}
