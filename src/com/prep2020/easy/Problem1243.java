package com.prep2020.easy;
import java.util.*;
public class Problem1243 {
	public List<Integer> transformArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        boolean changed = true;
        while(changed) {
        	changed = false;
        	for (int i = 1; i < arr.length - 1; i++) {
        		if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
        			newArr[i]++;
        			changed = true;
        		} else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        			newArr[i]--;
        			changed = true;
        		}
        	}
        	arr = Arrays.copyOf(newArr, newArr.length);
        }
        List<Integer> result = new ArrayList<>();
        for (int i : arr) result.add(i);
        return result;
    }
}
