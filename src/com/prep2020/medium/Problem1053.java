package com.prep2020.medium;

public class Problem1053 {
	/**
	 * O(N)
	 * @param arr
	 * @return
	 */
	public int[] prevPermOpt1(int[] arr) {
		int n = arr.length;
		int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i > 0; i--) {
        	if (arr[i - 1] > arr[i]) {
        		idx1 = i - 1;
        		idx2 = i;
        		for (int j = n - 1; j > i; j--) {
        			if (arr[j] > arr[idx2] && arr[j] < arr[i - 1]) {
        				idx2 = j;
        			}
        		}
        		break;
        	}
        }
        if (idx1 == -1) return arr;
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        return arr;
    }
}
