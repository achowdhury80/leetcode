package com.prep2020.easy;
import java.util.*;
public class Problem1128 {
	/**
	 * O(N) time and o(1) space
	 * @param dominoes
	 * @return
	 */
	public int numEquivDominoPairs(int[][] dominoes) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int[] pair : dominoes) {
    	   if (pair[0] > pair[1]) {
    		   int temp = pair[0];
    		   pair[0] = pair[1];
    		   pair[1] = temp;
    	   }
    	   int key = ((pair[0] << 4) | pair[1]);
    	   map.put(key, map.getOrDefault(key, 0) + 1);
       }
       int result = 0;
       for (int val : map.values()) {
    	   if (val > 1) {
    		   result += val * (val - 1) / 2;
    	   }
       }
       return result;
    }
}
