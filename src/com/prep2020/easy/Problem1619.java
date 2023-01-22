package com.prep2020.easy;

import java.util.Arrays;

public class Problem1619 {
	/**
	 * O(NlogN)
	 * @param arr
	 * @return
	 */
	public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for (int i = n / 20; i < (n - (n / 20)) ; i++) sum += arr[i];
        return ((0. + sum) * 10) / (9 * n);
        
    }
}
