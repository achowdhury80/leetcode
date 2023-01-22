package com.prep2020.easy;
import java.util.*;
public class Problem1213 {
	/**
	 * O(N)
	 * @param arr1
	 * @param arr2
	 * @param arr3
	 * @return
	 */
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
        	if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        		result.add(arr1[i]);
        		i++;
        		j++;
        		k++;
        	} else {
        		if (arr1[i] < arr2[j] || arr1[i] < arr3[k]) i++;
        		else if (arr2[j] < arr1[i] || arr2[j] < arr3[k]) j++;
        		else if (arr3[k] < arr1[i] || arr3[k] < arr2[j]) k++;
        	}
        }
        return result;
    }
}
