package com.prep2020.medium;

public class Problem1737 {
	/**
	 * O(n)
	 * @param a
	 * @param b
	 * @return
	 */
	public int minCharacters(String a, String b) {
        int[] arr1 = new int[26], arr2 = new int[26];
        for (char c : a.toCharArray()) {
        	arr1[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
        	arr2[c - 'a']++;
        }
        int totalLength = a.length() + b.length(), result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) 
        	result = Math.min(result, totalLength - arr1[i] - arr2[i]);
        int[] cum1 = new int[26], cum2 = new int[26];
        cum1[0] = arr1[0];
        cum2[0] = arr2[0];
        for (int i = 1; i < 26; i++) {
        	cum1[i] = cum1[i - 1] + arr1[i];
        	cum2[i] = cum2[i - 1] + arr2[i];
        }
        result = Math.min(result, makeFirstBigger(arr1, arr2, cum1, cum2));
        result = Math.min(result, makeFirstBigger(arr2, arr1, cum2, cum1));
        return result;
    }

	private int makeFirstBigger(int[] arr1, int[] arr2, int[] cum1, int[] cum2) {
		int result = Integer.MAX_VALUE;
		int bigger = arr2[25];
		for (int i = 24; i > -1; i--) {
			result = Math.min(result, cum1[i] + bigger);
			bigger += arr2[i];
		}
		return result;
	}
}
