package com.prep2020.medium;

public class Problem1362 {
	/**
	 * O(sqrt(N))
	 * @param num
	 * @return
	 */
	public int[] closestDivisors(int num) {
        int[] arr1 = findClosest(num + 1), arr2 = findClosest(num + 2);
        if (arr1[1] - arr1[0] < arr2[1] - arr2[0]) return arr1;
        return arr2;
    }

	private int[] findClosest(int num) {
		int i = (int)Math.sqrt(num);
		while (i > 1) {
			if (num % i == 0) return new int[] {i, num / i};
			i--;
		}
		return new int[] {1, num};
	}
}
