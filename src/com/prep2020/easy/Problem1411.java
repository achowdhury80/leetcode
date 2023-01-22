package com.prep2020.easy;
import java.util.*;
public class Problem1411 {
	/**
	 * O(N)
	 * @param target
	 * @param n
	 * @return
	 */
	public List<String> buildArray(int[] target, int n) {
		List<String> result = new ArrayList<>();
		int listStart = 1;
		for (int i : target) {
			while(i > listStart) {
				result.add("Push");
				result.add("Pop");
				listStart++;
			}
			if (i == listStart) {
				result.add("Push");
				listStart++;
			} 
		}
		return result;
    }
}
