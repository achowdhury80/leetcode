package com.prep2020.easy;

public class Problem1013 {
	/**
	 * O(N) and O(1)
	 * @param arr
	 * @return
	 */
	public boolean canThreePartsEqualSum(int[] arr) {
		int n = arr.length;
        for (int i = 1; i < n; i++) arr[i] += arr[i - 1];
        if (arr[n - 1] % 3 != 0) return false;
        int firstPartEndIndex = -1;
        for (int i = 0; i < n - 2; i++) {
        	if (arr[i] == arr[n - 1] / 3) {
        		firstPartEndIndex = i;
        		break;
        	}
        }
        if (firstPartEndIndex == - 1) return false;
        for (int i = n - 1; i > firstPartEndIndex + 1; i--) {
        	if (arr[n - 1] - arr[i - 1] == arr[n - 1] / 3) {
        		return true;
        	}
        }
        return false;
    }
}
