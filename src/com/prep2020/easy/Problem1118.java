package com.prep2020.easy;

public class Problem1118 {
	/**
	 * O(1)
	 * @param Y
	 * @param M
	 * @return
	 */
	public int numberOfDays(int Y, int M) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (M != 2) return days[M - 1];
        if (Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0)) return 29;
        return 28;
    }
}
