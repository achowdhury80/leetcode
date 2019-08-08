package com.leet.algo;
import java.util.*;
public class Prob975 {
	/**
	 * dp[i][0] is starting ith index with odd jump whether it reaches end
	 *  dp[i][1] is starting ith index with even jump whether it reaches end
	 *  the tree map is a map of value and index to find next lower and upper value
	 * @param A
	 * @return
	 */
	public int oddEvenJumps(int[] A) {
		boolean[][] dp = new boolean[A.length][2];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[A.length - 1], A.length - 1);
        dp[A.length - 1] = new boolean[] {true, true};
        int result = 1;
        for (int i = A.length - 2; i > -1; i--) {
        	int[] cur = new int[] {A[i], i};
        	Map.Entry<Integer, Integer> maxLower = treeMap.floorEntry(A[i]);
        	Map.Entry<Integer, Integer> minUpper = treeMap.ceilingEntry(A[i]);
        	// odd jump
        	if (minUpper == null || !dp[minUpper.getValue()][1]) {
        		dp[i][0] = false;
        	} else {
        		dp[i][0] = true;
        		result++;
        	}
        	
        	// even jump
        	if (maxLower == null || !dp[maxLower.getValue()][0]) {
        		dp[i][1] = false;
        	} else {
        		dp[i][1] = true;
        	}
        	treeMap.put(A[i], i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob975 prob = new Prob975();
		System.out.println(prob.oddEvenJumps(new int[] {2,3,1,1,4}));
	}
}
