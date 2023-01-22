package com.prep2020.easy;
import java.util.*;
public class Problem118 {
	/**
	 * O(N^2)
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows < 1) return result;
		List<Integer> last = new ArrayList<>();
		result.add(last);
		last.add(1);
		for (int i = 1; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			for (int j = 0; j < last.size() - 1; j++) list.add(last.get(j) + last.get(j + 1));
			list.add(1);
			result.add(list);
			last = list;
		}
		return result;
    }
}
