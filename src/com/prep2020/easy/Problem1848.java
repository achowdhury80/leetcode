package com.prep2020.easy;

public class Problem1848 {
	public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int leftMover = Math.min(start, n - 1), rightMover = start;
        while(true) {
        	if (leftMover > -1) {
        		if (nums[leftMover] == target) return Math.abs(start - leftMover);
        		leftMover--;
        	}
        	if (rightMover < n) {
        		if (nums[rightMover] == target) return Math.abs(start - rightMover);
        		rightMover++;
        	}
        }
    }
	
	public static void main(String[] args) {
		Problem1848 problem = new Problem1848();
		System.out.println(problem.getMinDistance(new int[] {1, 2, 3, 4, 5}, 5, 3));
	}
}
