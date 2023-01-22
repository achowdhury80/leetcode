package com.prep2020.medium;

public class Problem424 {
	/**
	 * O(N)
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {
        int n = s.length();
        int start = -1, result = 1, idx = s.charAt(0) - 'A';
        int[] arr = new int[26];
        arr[idx]++;
        int maxFreqIdx = idx;
        for (int i = 1; i < n; i++) {
        	idx = s.charAt(i) - 'A';
        	arr[idx]++;
        	if (maxFreqIdx != idx && arr[idx] >= arr[maxFreqIdx]) maxFreqIdx = idx;        	
        	while (i - start - arr[maxFreqIdx] > k) {
        		start++;
        		idx = s.charAt(start) - 'A';
        		arr[idx]--;
        		if (idx == maxFreqIdx) {
	        		for (int j = 0; j < 26; j++) {
	        			maxFreqIdx = arr[maxFreqIdx] < arr[j] ? j : maxFreqIdx;
	        		}
        		}
        	}
        	result = Math.max(result, i - start);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem424 problem = new Problem424();
		System.out.println(problem.characterReplacement("AABABBA", 1));
	}
}
