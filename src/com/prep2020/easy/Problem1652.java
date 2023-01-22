package com.prep2020.easy;

public class Problem1652 {
	public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];
        for (int i = 1; i < code.length; i++) code[i] += code[i - 1];
        int[] result = new int[code.length];
        for (int i = 0; i < code.length; i++) {
        	result[i] = findVal(code, i, k);
        }
        return result;
    }

	private int findVal(int[] code, int i, int k) {
		int n = code.length;
		if (k > 0) {
			int start = (i + 1) % n;
			int end = (i + k) % n;
			if (start <= end) return findSum(code, start, end);
			if (end + 1 == start) return code[code.length - 1];
			return code[code.length - 1] - findSum(code, end + 1, start - 1);
		} else {
			int start =  (i - 1 + n) % n;
			int end = (i + k + n) % n;
			if (start >= end) return findSum(code, end, start);
			if (start + 1 == end) return code[code.length - 1];
			return code[code.length - 1] - findSum(code, start + 1, end - 1);
		}
	}
	
	private int findSum(int[] code, int start, int end) {
		return code[end] - (start == 0 ? 0 : code[start - 1]);
	}
	
	public static void main(String[] args) {
		Problem1652 problem = new Problem1652();
		int[] result = problem.decrypt(new int[] {2, 4, 9, 3}, -2);
		for (int i : result) System.out.print(i + ", ");
	}
}
