package com.prep2020.easy;

public class Problem1758 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int minOperations(String s) {
		int lastZeroCount = 0, lastOneCount = 0;
		for (char c : s.toCharArray()) {
			if (c == '1') {
				int temp = lastOneCount;
				lastOneCount = lastZeroCount;
				lastZeroCount = temp + 1;
			} else {
				int temp = lastZeroCount;
				lastZeroCount = lastOneCount;
				lastOneCount = temp + 1;
			}
		}
        return Math.min(lastZeroCount, lastOneCount);
    }
	
	public static void main(String[] args) {
		Problem1758 problem = new Problem1758();
		System.out.println(problem.minOperations("1111"));
	}
}
