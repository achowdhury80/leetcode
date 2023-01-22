package com.prep2020.medium;
import java.util.*;
public class Problem1276 {
	/**
	 * O(1)
	 * @param tomatoSlices
	 * @param cheeseSlices
	 * @return
	 */
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 == 1) 
        	return Arrays.asList();
        if (tomatoSlices == 0) return Arrays.asList(0, 0);
        /*
         * x = jumbo, y = small
         * 4x + 2y = tomatoSlices
         * x + y = cheeseSlices
         */
        int jumbo2 = tomatoSlices - 2 * cheeseSlices;
        if (jumbo2 < 0) return Arrays.asList();
        int jumbo = jumbo2 / 2;
        int small = cheeseSlices - jumbo;
        if (small < 0) return Arrays.asList();
        return Arrays.asList(jumbo, cheeseSlices - jumbo);
    }
}
