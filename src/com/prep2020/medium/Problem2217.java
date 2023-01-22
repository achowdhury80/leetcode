package com.prep2020.medium;

public class Problem2217 {
	public long[] kthPalindrome(int[] queries, int intLength) {
        int midLen = (intLength + 1) / 2;
        String base = "1";
        int max = 9;
        for (int i = 0; i < midLen - 1; i++) {
        	base += "0";
        	max *= 10;
        }
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	if (queries[i] > max) result[i] = -1;
        	else {
        		String s = findNth(base, queries[i] - 1);
        		String toReverse = intLength % 2 == 1 ? s.substring(0, s.length() - 1) : s;
        		String pal = s + new StringBuilder(toReverse).reverse();
        		result[i] = Long.parseLong(pal);
        	}
        }
        return result;
    }
	
	private String findNth(String base, int n) {
		if (n == 0) return base;
		int pow = 1, i = base.length() - 1;
		while (pow < n) {
			if (pow * 10 <= n) {
				i--;
				pow *= 10;
			} else break;
		}
		int toAdd = n / pow;
		n -= pow * (n / pow);
		String result = base.substring(0, i) + (char)(base.charAt(i) + toAdd) + base.substring(i + 1);
		if (n == 0) return result;
		return findNth(result, n);
	}
	
	public static void main(String[] args) {
		Problem2217 problem = new Problem2217();
		System.out.println(problem.kthPalindrome(new int[] {1,2,3,4,5,90}, 3));
	}
}
