package com.prep2020.easy;

public class Problem2164 {
	public int[] sortEvenOdd(int[] nums) {
		int[] even = new int[101], odd = new int[101];
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) even[nums[i]]++;
			else odd[nums[i]]++;
		}
        int evenIdx = 0;
        for (int i = 1; i < 101; i++) {
        	if (even[i] > 0) {
        		nums[evenIdx] = i;
        		evenIdx += 2;
        		even[i]--;
        		if (even[i] > 0) i--;
        	}
        }
        int oddIdx = 1;
        for (int i = 100; i > 0; i--) {
        	if (odd[i] > 0) {
        		nums[oddIdx] = i;
        		oddIdx += 2;
        		odd[i]--;
        		if (odd[i] > 0) i++;
        	}
        }
        return nums;
    }
	
	public static void main(String[] args) {
		Problem2164 problem = new Problem2164();
		System.out.println(problem.sortEvenOdd(new int[] {4, 1, 2, 3}));
	}
}
