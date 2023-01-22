package com.prep2020.medium;

public class Problem1100 {
	/**
	 * O(N)
	 * @param S
	 * @param K
	 * @return
	 */
	public int numKLenSubstrNoRepeats(String S, int K) {
		if (K > S.length() || K > 26) return 0;
        int[] arr = new int[26];
        int count = 0;
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
        	int idx = S.charAt(i) - 'a';
        	arr[idx]++;
        	if (arr[idx] == 1) count++;
        	if (i - K > -1) {
        		arr[S.charAt(i - K) - 'a']--;
        		if (arr[S.charAt(i - K) - 'a'] == 0) count--;
        	}
        	if (count == K) result++;
        }
        return result;
    }
}
