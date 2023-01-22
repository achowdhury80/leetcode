package com.prep2020.easy;
import java.util.*;
public class Problem575 {
	/**
	 * O(N)
	 * @param candyType
	 * @return
	 */
	public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int c : candyType) set.add(c);
        return Math.min(candyType .length/ 2, set.size());
    }
}
