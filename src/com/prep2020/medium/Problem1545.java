package com.prep2020.medium;

public class Problem1545 {
	/**
	 * O(N)
	 * @param n
	 * @param k
	 * @return
	 */
	public char findKthBit(int n, int k) {
		if (n == 1) return '0';
        int count = (int)Math.pow(2, n) - 1;
        if (k == count / 2 + 1) return '1';
        if ( k <= count / 2) return findKthBit(n - 1, k);
        k -= (count / 2  + 1);
        return reverse(findKthBit(n - 1, count / 2 - k + 1));
    }
	
	private char reverse(char ch) {
		return ch == '0' ? '1' : '0';
	}

	public static void main(String[] args) {
		Problem1545 problem = new Problem1545();
		System.out.println(problem.findKthBit(2, 3));
		System.out.println(problem.findKthBit(4, 11));
		System.out.println(problem.findKthBit(3, 5));
	}
}
