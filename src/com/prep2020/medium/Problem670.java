package com.prep2020.medium;

public class Problem670 {
	public int maximumSwap(int num) {
        char[] arr = ("" + num).toCharArray();
        int breakIndex = -1, maxIndex = -1;
        for (int i = 0; i < arr.length - 1; i++) {
        	if (arr[i] < arr[i + 1]) {
        		maxIndex = i + 1;
        		for (int j = maxIndex + 1; j < arr.length; j++) {
        			if (arr[j] >= arr[maxIndex]) {
        				maxIndex = j;
        			}
        		}
        		breakIndex = i;
        		for (int j = breakIndex - 1; j > -1; j--) {
        			if (arr[j] >= arr[maxIndex]) break;
        			breakIndex = j;
        		}
        		char c = arr[breakIndex];
        		arr[breakIndex] = arr[maxIndex];
        		arr[maxIndex] = c;
        		return Integer.parseInt(new String(arr));
        	}
        }
        return num;
    }
}
