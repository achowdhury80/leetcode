package com.prep2020.easy;

public class Problem476 {
	/**
	 * O(1)
	 * @param num
	 * @return
	 */
	public int findComplement(int num) {
        int mask = 0;
        boolean found = false;
        for (int i = 31; i > -1; i--) {
        	int shifted =  (1 << i);
        	if (found) mask |= shifted;
        	else if ((num & shifted) > 0) {
        		found = true;
        		mask |= shifted;
        	}
        }
        return  num ^ mask;
    }
	
	public static void main(String[] args) {
		Problem476 problem = new Problem476();
		System.out.println(problem.findComplement(5));
	}
}
