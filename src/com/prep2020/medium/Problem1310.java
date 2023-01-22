package com.prep2020.medium;

public class Problem1310 {
	public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) arr[i] = arr[i] ^ arr[i - 1];
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	result[i] = arr[queries[i][1]] ^ (queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1]);
        }
        return result;
    }
}
