package com.prep2020.easy;
import java.util.*;
public class Problem760 {
	/**
	 * O(N) time and space
	 * @param A
	 * @param B
	 * @return
	 */
	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
        	map.put(B[i], map.getOrDefault(B[i], new ArrayList<>()));
        	map.get(B[i]).add(i);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        	int index = map.get(A[i]).remove(0);
        	result[i] = index;
        }
        return result;
    }
}
