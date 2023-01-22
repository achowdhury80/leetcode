package com.prep2020.easy;

public class Problem1342 {
	/**
	 * O(logN)
	 * @param num
	 * @return
	 */
	public int numberOfSteps (int num) {
        int result = 0;
        while(num > 0) {
        	if (num % 2 == 0) num /= 2;
        	else num--;
        	result++;
        }
        return result;
    }
}
