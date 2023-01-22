package com.prep2020.medium;

import java.util.Arrays;

public class Problem869 {
	/**
	 * O((logN)^2) time and O(logN) space
	 * @param n
	 * @return
	 */
	public boolean reorderedPowerOf2(int n) {
		int[] arr = count(n);
		for (int i = 0; i < 31; ++i)
            if (Arrays.equals(arr, count(1 << i)))
                return true;
        return false;
    }
	
	private int[] count(int n) {
		int[] arr = new int[10];
		if (n == 0) {
			arr[0]++;
			return arr;
		}
		while(n > 0) {
			arr[n % 10]++;
			n /= 10;
		}
		return arr;
	}
}
