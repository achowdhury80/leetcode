package com.leet.algo;

public class Prob1089 {
	public void duplicateZeros(int[] arr) {
		int n = arr.length - 1;
		int i = 0;
		for (; i < n; i++) {
        	if (arr[i] == 0) n--;
        }
        int k = arr.length - 1;
        if (i == n) arr[k--] = arr[n--];
        else {
        	arr[k--] = 0;
        	arr[k--] = 0;
        	n--;
        }
        for (int j = n; j > -1; j--) {
        	arr[k--] = arr[j];
        	if (arr[j] == 0) arr[k--] = 0;
        }
    }
}
