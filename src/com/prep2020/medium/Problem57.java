package com.prep2020.medium;
import java.util.*;
public class Problem57 {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<>();
		for (int[] intv : intervals) list.add(intv);
		list.add(0, newInterval);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i)[0] > list.get(i - 1)[1]) break;
			if (list.get(i)[1] < list.get(i - 1)[0]) {
				int[] temp = list.get(i);
				list.set(i, list.get(i - 1));
				list.set(i - 1, temp);
			} else {
				list.set(i - 1, new int[] {
						Math.min(list.get(i - 1)[0], list.get(i)[0]),
						Math.max(list.get(i - 1)[1], list.get(i)[1])});
				list.remove(i);
				i--;
			}
		}
		int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
