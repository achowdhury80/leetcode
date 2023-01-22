package com.prep2020.medium;
import java.util.*;
public class Problem1237 {
	/**
	 * O(NlogN)
	 * @param customfunction
	 * @param z
	 * @return
	 */
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
        	int low = 1, high = 1000;
        	while(low <= high) {
        		int mid = low + (high - low) / 2;
        		int val = customfunction.f(i, mid);
        		if (val == z) {
        			result.add(Arrays.asList(i, mid));
        			break;
        		} else if (val > z) high = mid - 1;
        		else low = mid + 1;
        	}
        }
        return result;
    }
	
	class CustomFunction {
		    public int f(int x, int y) {return 0;} 
		  };
}
