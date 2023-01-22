package com.prep2020.medium;
import java.util.*;
public class Problem1562 {
	public int findLatestStep(int[] arr, int m) {
		int n = arr.length;
		if (m == n) return n;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		treeMap.put(1, n);
        for (int i = n - 1; i > 0; i--) {
        	int start = treeMap.floorKey(arr[i]);
        	int end = treeMap.remove(start);
        	if (start == arr[i] || end == arr[i]) {
        		if (end - start == m) return i;
        		if (start == arr[i]) treeMap.put(start + 1, end);
        		else treeMap.put(start, end - 1);
        	} else {
        		if (arr[i] - start == m || end - arr[i] == m) return i;
        		treeMap.put(start, arr[i] - 1);
        		treeMap.put(arr[i] + 1, end);
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem1562 problem = new Problem1562();
		System.out.println(problem.findLatestStep(
				new int[] {3, 1, 5, 4, 2}, 2));
	}
}
