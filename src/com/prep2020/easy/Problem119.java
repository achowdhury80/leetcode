package com.prep2020.easy;
import java.util.*;
public class Problem119 {
	/**
	 * O(N^2)
	 * @param numRows
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> last = new ArrayList<>();
		last.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			for (int j = 0; j < last.size() - 1; j++) list.add(last.get(j) + last.get(j + 1));
			list.add(1);
			last = list;
		}
		return last;
    }
}
