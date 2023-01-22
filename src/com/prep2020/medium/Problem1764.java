package com.prep2020.medium;
import java.util.*;
public class Problem1764 {
	/**
	 * O(n^2)
	 * @param groups
	 * @param nums
	 * @return
	 */
	public boolean canChoose(int[][] groups, int[] nums) {
		int start = 0;
        for (int[] group : groups) {
        	int idx = findStartIndex(nums, start, group);
        	if (idx < 0) return false;
        	start = idx + group.length;
        }
        return true;
    }

	private int findStartIndex(int[] nums, int start, int[] group) {
		int n = group.length;
		for (int i = start; i + n - 1 < nums.length; i++) {
			boolean found = true;
			for (int j = 0; j < n; j++) {
				if (group[j] != nums[i + j]) {
					found = false;
					break;
				}
			}
			if (found) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Problem1764 problem = new Problem1764();
		System.out.println(problem.canChoose(new int[][]{{1,-1,-1},{3,-2,0}},
				new int[] {1,-1,0,1,-1,-1,3,-2,0}));
	}
}
