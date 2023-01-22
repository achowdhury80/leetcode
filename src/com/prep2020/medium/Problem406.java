package com.prep2020.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem406 {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (x, y) -> (x[0] == y[0]) ? (x[1] - y[1]) : (y[0] - x[0]));
		List<int[]> list = new ArrayList<>();
		for (int[] a : people) {
			if (a[1] == list.size()) list.add(a);
			else list.add(a[1], a);
		}
		int[][] result = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
		return result;
	}
}
