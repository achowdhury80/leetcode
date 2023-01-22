package com.prep2020.easy;

public class Problem1009 {
	/**
	 * O(1)
	 * @param N
	 * @return
	 */
	public int bitwiseComplement(int N) {
		if (N == 0) return 1;
        int count = 0;
        int num = N;
        while(num > 0) {
        	count++;
        	num >>= 1;
        }
        return N ^ ((1 << count) - 1);
        
    }
	
	public static void main(String[] args) {
		Problem1009 problem = new Problem1009();
		System.out.println(problem.bitwiseComplement(5));
	}
}
