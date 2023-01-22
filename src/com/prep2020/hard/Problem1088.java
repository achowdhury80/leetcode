package com.prep2020.hard;

public class Problem1088 {
	public int confusingNumberII(int n) {
        int[] candidate = new int[] {0, 1, 6, 8, 9};
        int[] result = new int[1];
        for (int i : new int[] {1, 6, 8, 9}) {
        	helper(i, candidate, n, result);
        }
        return result[0];
    }

	private void helper(long x, int[] candidate, int n, int[] result) {
		if (x > n) return;
		if (isConfusing(x)) result[0]++;
		for (int c : candidate) helper(x * 10 + c, candidate, n, result);
		
	}

	private boolean isConfusing(long x) {
		long rev = 0;
		long n = x;
		while(n > 0) {
			int rem = (int)(n % 10);
			if (rem == 6) rem = 9;
			else if (rem == 9) rem = 6;
			rev = rev * 10 + rem;
			n /= 10;
		}
		return x != rev;
	}
	
	public static void main(String[] args) {
		Problem1088 problem = new Problem1088();
		System.out.println(problem.confusingNumberII(20));
	}
}
