package com.prep2020.easy;
import java.util.*;
public class Problem728 {
	/**
	 * O(w * (right - left)) where w = avg width of a number
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDivisible(i)) result.add(i);
		}
		return result;
    }

	private boolean isSelfDivisible(int i) {
		if (i == 0) return false;
		int num = i;
		while(num > 0) {
			int rem = (num % 10);
			if (rem == 0 || i % rem != 0) return false;
			num /= 10;
		}
		return true;
	}
}
