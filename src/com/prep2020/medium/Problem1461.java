package com.prep2020.medium;

public class Problem1461 {
	/**
	 * O(N) time and O(2^K) space
	 * @param s
	 * @param k
	 * @return
	 */
	public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (n < k) return false;
        int totalNumbers = (int)Math.pow(2, k);
        boolean[] arr = new boolean[totalNumbers];
        int num = 0;
        for (int i = 0; i < k; i++) {
        	char c = s.charAt(i);
        	num <<= 1;
        	if (c == '1') num |= 1;
        }
        arr[num] = true;
        int count = 1;
        for (int i = k; i < n; i++) {
        	int mask = (1 << (k - 1)) - 1;
        	num &= mask; 
        	char c = s.charAt(i);
        	num <<= 1;
        	if (c == '1') num |= 1;
        	if (!arr[num]) {
        		arr[num] = true;
        		count++;
        		if (count == totalNumbers) return true;
        	}
        }
        return count == totalNumbers;
    }
	
	public static void main(String[] args) {
		Problem1461 problem = new Problem1461();
		System.out.println(problem.hasAllCodes("00110110", 2));
	}
}
