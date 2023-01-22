package com.prep2020.medium;

import java.util.Arrays;

public class Problem1433 {
	/**
	 * O(NlogN)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Boolean smaller = null;
        for (int i = 0; i < arr1.length; i++) {
        	if (arr1[i] == arr2[i]) continue;
        	if (arr1[i] < arr2[i]) {
        		if (smaller != null && !smaller) return false;
        		smaller = true;
        	} else {
        		if (smaller != null && smaller) return false;
        		smaller = false;
        	}
        }
        return true;
    }
}
