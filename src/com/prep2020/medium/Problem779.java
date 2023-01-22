package com.prep2020.medium;

public class Problem779 {
	/**
	 * O(N) time and space
	 * @param n
	 * @param k
	 * @return
	 */
	public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int last = kthGrammar(n - 1, k % 2 == 1 ? (k / 2 + 1) : (k / 2) );
        if (k % 2 == 1) return last;
        return last ^ 1;
    }
}
