package com.leet.algo;

public class Prob1060 {
	public int missingElement(int[] nums, int k) {
        return missingElement(nums, 0, nums.length - 1, k);
    }
	
	public int missingElement(int[] nums, int start, int end, int k) {
		if (start >= end) return nums[end] + k;
		if (nums[end] - nums[start] < end - start + k) return nums[end] + k - ((nums[end] - nums[start]) - (end - start));
		if (start + 1 == end) return nums[start] + k;
		int mid = start + (end - start) / 2;
		if (nums[mid] - nums[start] < mid - start + k) return missingElement(nums, mid, end, k - ((nums[mid] - nums[start]) - (mid - start)));
		return missingElement(nums, start, mid, k);
		
    }
	
	public static void main(String[] args) {
		Prob1060 prob = new Prob1060();
		System.out.println(prob.missingElement(new int[] {4,7,9,10}, 1));
		System.out.println(prob.missingElement(new int[] {4,7,9,10}, 3));
		System.out.println(prob.missingElement(new int[] {1, 2, 4}, 3));
	}
}
