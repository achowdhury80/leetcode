package com.prep2020.medium;

public class Problem1558 {
	/**
	 * O(n * log(max))
	 * @param nums
	 * @return
	 */
	public int minOperations(int[] nums) {
        int increment = 0, doubles = 0;
        for (int num : nums) {
        	int numberOfDouble = 0;
        	while(num != 0) {
        		if (num % 2 == 1) {
        			num--;
        			increment++;
        		} else {
        			num >>= 1;
        			numberOfDouble++;
        		}
        	}
        	doubles = Math.max(doubles, numberOfDouble);
        }
        return increment + doubles;
    }
}
