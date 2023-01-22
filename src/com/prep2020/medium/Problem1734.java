package com.prep2020.medium;

public class Problem1734 {
	/**
	 * O(N)
	 * @param encoded
	 * @return
	 */
	public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int xorAll = 0;
        for (int i = 1; i <= n; i++) xorAll ^= i;
        int xorWithoutFirst = 0;
        for (int i = 1; i < n - 1; i += 2)  xorWithoutFirst ^= encoded[i];
        int[] result = new int[n];
        result[0] = xorAll ^ xorWithoutFirst;
        for (int i = 1; i < n; i++) result[i] = result[i - 1] ^ encoded[i - 1];
        return result;
    }
	
	public static void main(String[] args) {
		Problem1734 problem = new Problem1734();
		System.out.println(problem.decode(new int[] {3, 1}));
	}
}
