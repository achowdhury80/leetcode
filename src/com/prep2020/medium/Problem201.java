package com.prep2020.medium;

public class Problem201 {
	/**
	 * check each bit starting from the leftmost for biggest and smallest number
	 * if they are same, the bit is part of result
	 * if not, return
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 31; i > -1; i--) {
        	//check whether ith bit are equal
        	if(((m >> i) & 1) == ((n >> i) & 1)) {
        		// set the ith bit of result equal to ith bit of m or n
        		result ^= (m & (1 << i));
        	}
        	else return result;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem201 problem = new Problem201();
		//System.out.println(problem.rangeBitwiseAnd(5, 7));
		System.out.println(problem.rangeBitwiseAnd(2147483646, 2147483647));
	}
}
