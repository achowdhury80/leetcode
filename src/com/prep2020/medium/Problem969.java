package com.prep2020.medium;
import java.util.*;
public class Problem969 {
	/**
	 * O(N^2)
	 * @param arr
	 * @return
	 */
	public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        int cur = n, lastIndex = n - 1;
        List<Integer> result = new ArrayList<>();
        while(cur > 1) {
        	int curIndex = findIndex(arr, cur, lastIndex);
        	if (curIndex != cur - 1) {
        		reverse(arr, 0, curIndex);
        		result.add(curIndex + 1);
        		reverse(arr, 0, cur - 1);
        		result.add(cur);
        	}
        	cur--;
        }
        return result;
    }

	private int findIndex(int[] arr, int cur, int lastIndex) {
		for (int i = 0; i <= lastIndex; i++) {
			if (arr[i] == cur) return i;
		}
		return -1;
	}
	
	private void reverse(int[] arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	
}
