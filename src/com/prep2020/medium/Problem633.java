package com.prep2020.medium;
import java.util.*;

public class Problem633 {
	/**
	 * O(n^(1/2)logN)
	 * @param c
	 * @return
	 */
	public boolean judgeSquareSum(int c) {
        if (c < 3) return true;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; 1l * i * i <= c; i++) list.add(i * i);
        for (int i = 0; i < list.size(); i++) {
        	if (found(list, i, c - list.get(i))) return true;
        }
        return false;
    }

	private boolean found(List<Integer> list, int startIndex, int num) {
		int low = startIndex, high = list.size() - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (list.get(mid) == num) return true;
			else if (list.get(mid) > num) high = mid - 1;
			else low = mid + 1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Problem633 problem = new Problem633();
		System.out.println(problem.judgeSquareSum(8));
	}
}
