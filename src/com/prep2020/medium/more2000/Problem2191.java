package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2191 {
	public int[] sortJumbled(int[] mapping, int[] nums) {
		int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
        	arr[i] = new int[] {i, nums[i], findOriginalValue(mapping, nums[i])};
        }
        Arrays.sort(arr, (x, y) -> ((x[2] == y[2]) ? (x[0] - y[0]) : (x[2] - y[2])));
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = arr[i][1];
        return result;
    }

	private int findOriginalValue(int[] mapping, int i) {
		if (i == 0) return mapping[i];
		int result = 0, mult = 1;
		while(i > 0) {
			result += mult * mapping[(i % 10)];
			i /= 10;
			mult *= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem2191 problem = new Problem2191();
		System.out.println(problem.sortJumbled(new int[] {8,9,4,0,2,1,3,5,7,6},
				new int[] {991,338,38}));
	}
}
