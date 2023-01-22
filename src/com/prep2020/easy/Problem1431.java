package com.prep2020.easy;
import java.util.*;
public class Problem1431 {
	/**
	 * O(N)
	 * @param candies
	 * @param extraCandies
	 * @return
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) max = Math.max(max, candy);
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
        	if ((candy + extraCandies) >= max) result.add(true);
        	else result.add(false);
        }
        return result;
    }
}
