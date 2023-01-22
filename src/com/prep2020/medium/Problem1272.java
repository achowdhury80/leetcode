package com.prep2020.medium;
import java.util.*;
public class Problem1272 {
	/**
	 * O(N) time
	 * @param intervals
	 * @param toBeRemoved
	 * @return
	 */
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> result = new ArrayList<>();
		for (int[] intv : intervals) {
			if (intv[1] <= toBeRemoved[0] || intv[0] >= toBeRemoved[1]) result.add(Arrays.asList(intv[0], intv[1]));
			else {
				if (intv[0] < toBeRemoved[0]) result.add(Arrays.asList(intv[0], toBeRemoved[0]));
				if(intv[1] > toBeRemoved[1]) result.add(Arrays.asList(toBeRemoved[1], intv[1]));
			}
		}
		return result;
    }
}
