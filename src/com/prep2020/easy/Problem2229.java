package com.prep2020.easy;

public class Problem2229 {
	public boolean isConsecutive(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean[] arr = new boolean[100001];
        for (int n : nums) {
        	if (arr[n]) return false;
        	arr[n] = true;
        	min = Math.min(min, n);
        	max = Math.max(max, n);
        }
        return max - min + 1 == nums.length;
    }
	
	public static void main(String[] args) {
		Problem2229 problem = new Problem2229();
		System.out.println(problem.isConsecutive(new int[] {1, 3, 4, 2}));
	}
}
