package com.prep2020.hard;

public class Problem410 {
	public int splitArray(int[] nums, int m) {
        int low = -1, high = 0;
        for (int num : nums) {
        	low = Math.max(low, num);
        	high += num;
        }
        int result = -1;
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	int groups = findGroupsCount(nums, mid, m);
        	if (groups == m) {
        		result = mid;
        		high = mid - 1;
        	} else if (groups > m) low = mid + 1;
        	else high = mid - 1;
        }
        return result;
    }

	private int findGroupsCount(int[] nums, int mid, int m) {
		int n = nums.length;
		int groups = 0, curSum = nums[0];
		for (int i = 1; i < n; i++) {
			int remaining = n - i;
			if (groups + remaining + 1 == m) return m;
			if (curSum + nums[i] > mid) {
				groups++;
				curSum = nums[i];
			} else curSum += nums[i];
		}
		groups++;
		return groups;
	}
	
	public static void main(String[] args) {
		Problem410 problem = new Problem410();
		System.out.println(problem.splitArray(new int[] {7,2,5,10,8}, 2));
		System.out.println(problem.splitArray(new int[] {1,2,3,4,5}, 2));
		System.out.println(problem.splitArray(new int[] {2,3,1,1,1,1,1}, 5));
		System.out.println(problem.splitArray(new int[] {0,8,1,4}, 4));
		
	}
}
