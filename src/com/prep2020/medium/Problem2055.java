package com.prep2020.medium;
import java.util.*;
public class Problem2055 {
	/**
	 * O(nlogN)
	 * @param s
	 * @param queries
	 * @return
	 */
	public int[] platesBetweenCandles(String s, int[][] queries) {
		// key candle pos and value number of plates before it
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int plates = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == '*') plates++;
        	else {
        		treeMap.put(i, plates);
        	}
        }
        int[] result = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
        	Map.Entry<Integer, Integer> right = treeMap.floorEntry(q[1]);
        	Map.Entry<Integer, Integer> left = treeMap.ceilingEntry(q[0]);
        	if (right == null || left == null) {
        		result[i++] = 0;
        		continue;
        	}
        	result[i++] = right.getKey() > left.getKey() ? (right.getValue() - left.getValue()) : 0;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2055 problem = new Problem2055();
		int[] result = problem.platesBetweenCandles("***|**|*****|**||**|*",
				new int[][] {{4,5}});
		System.out.println(result[0]);
	}
}
