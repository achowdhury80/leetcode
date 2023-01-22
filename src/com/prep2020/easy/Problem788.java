package com.prep2020.easy;

public class Problem788 {
	/**
	 * O(N)
	 * @param N
	 * @return
	 */
	public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
        	if (isValid(i)) result++;
        }
        return result;
    }

	private boolean isValid(int n) {
		boolean valid = false;
		while(n > 0) {
			int rem = n % 10;
			if (rem == 2 || rem == 5 || rem == 6 || rem == 9) valid = true;
			else if (rem == 3 || rem == 4 || rem == 7) return false;
			n /= 10;
		}
		return valid;
	}
}
