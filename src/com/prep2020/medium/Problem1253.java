package com.prep2020.medium;
import java.util.*;
public class Problem1253 {
	/**
	 * O(m*n)
	 * @param upper
	 * @param lower
	 * @param colsum
	 * @return
	 */
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
        	List<Integer> list = new ArrayList<>();
        	for (int j = 0; j < n; j++) {
        		list.add(0);
        	}
        	result.add(list);
        }
        
        int total = lower + upper;
        for (int i = 0; i < n; i++) {
        	if (colsum[i] == 2) {
        		upper--;
        		lower--;
        		result.get(0).set(i, 1);
        		result.get(1).set(i, 1);
        	}
        	total -= colsum[i];
        }
        if (total != 0) return new ArrayList<>();
        int i = 0;
        while(upper > 0 && i < n) {
        	if (result.get(0).get(i) == 0) {
        		if (colsum[i] == 1) {
	        		result.get(0).set(i, 1);
	        		upper--;
        		}
        	}
        	i++;
        }
        if (upper > 0) return new ArrayList<>();
        i = 0;
        while(lower > 0 && i < n) {
        	if (result.get(0).get(i) == 0 && result.get(1).get(i) == 0) {
        		if (colsum[i] == 1) {
	        		result.get(1).set(i, 1);
	        		lower--;
        		}
        	}
        	i++;
        }
        if (lower > 0)  return new ArrayList<>();
        return result;
    }
	
	public static void main(String[] args) {
		Problem1253 problem = new Problem1253();
		System.out.println(problem.reconstructMatrix(5, 5, new int[] {2,1,2,0,1,0,1,2,0,1}));
	}
}
