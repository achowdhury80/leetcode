package com.prep2020.hard;
import java.util.*;
public class Problem768 {
	public int maxChunksToSorted(int[] arr) {
		int n = arr.length;
		Integer[] index = new Integer[n];
		for (int i = 0; i < n; i++) index[i] = i;
		Arrays.sort(index, (x, y) -> arr[x] == arr[y] ? (x - y) : (arr[x] - arr[y]));
        int max = 0, result = 0;
        for (int i = 0; i < n; i++) {
        	max = Math.max(max, index[i]);
        	if (i == max) {
        		result++;
        		max++;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem768 problem = new Problem768();
		System.out.println(problem.maxChunksToSorted(new int[] {5, 4, 3, 2, 1}));
		System.out.println(problem.maxChunksToSorted(new int[] {4, 2, 2, 1, 1}));
	}
}
