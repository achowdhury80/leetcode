package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2170 {
	public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int[][] evenMaxes = findMaxes(nums, 0), oddMaxes = findMaxes(nums, 1);
        if (evenMaxes[0][0] != oddMaxes[0][0]) return (n - evenMaxes[0][1] - oddMaxes[0][1]);
        int result =  Math.min(oddMaxes[1][1] == 0 ? Integer.MAX_VALUE : (n - evenMaxes[0][1] - oddMaxes[1][1]), 
        		evenMaxes[1][1] == 0 ? Integer.MAX_VALUE : (n - evenMaxes[1][1] - oddMaxes[0][1]));
        if (result == Integer.MAX_VALUE) return oddMaxes[0][1];
        return result;
    }
	
	private int[][] findMaxes(int[] nums, int start) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = start; i < nums.length; i += 2) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		int[][] result = new int[2][2];
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > result[1][1]) {
				result[1] = new int[] {e.getKey(), e.getValue()};
				if (result[1][1] > result[0][1]) {
					int[] temp = result[1];
					result[1] = result[0];
					result[0] = temp;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem2170 problem = new Problem2170();
		System.out.println(problem.minimumOperations(new int[] {3,1,3,2,4,3}));
	}
}
