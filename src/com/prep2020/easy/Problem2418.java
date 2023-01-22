package com.prep2020.easy;

import java.util.Arrays;

public class Problem2418 {
	public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> heights[y] - heights[x]);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) result[i] = names[arr[i]];
        return result;
    }
}
