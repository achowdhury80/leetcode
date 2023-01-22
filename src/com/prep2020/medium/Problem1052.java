package com.prep2020.medium;

public class Problem1052 {
	/**
	 * O(N)
	 * @param customers
	 * @param grumpy
	 * @param X
	 * @return
	 */
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        int maxUnstatisFied = 0, curUnsatisFied = 0;
        for (int i = 0; i < customers.length; i++) {
        	if (grumpy[i] == 0) satisfied += customers[i];
        	else {
        		curUnsatisFied += customers[i];
        	}
        	if (i >= X && grumpy[i - X] == 1) curUnsatisFied -= customers[i - X];
        	maxUnstatisFied = Math.max(maxUnstatisFied, curUnsatisFied);
        }
        return satisfied + maxUnstatisFied;
    }
	
	public static void main(String[] args) {
		Problem1052 problem = new Problem1052();
		System.out.println(problem.maxSatisfied(new int[] {1,0,1,2,1,1,7,5},
				new int[] {0,1,0,1,0,1,0,1}, 3));
	}
}
