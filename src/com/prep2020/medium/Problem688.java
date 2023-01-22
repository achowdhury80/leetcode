package com.prep2020.medium;

import java.util.*;

public class Problem688 {
	public double knightProbability(int n, int k, int row, int column) {
        double[][] prob = new double[n][n];
        if (k == 0) return 1;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) prob[i][j] = 1;
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        while (k > 1) {
        	double[][] temp = new double[n][n];
        	for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
            		List<int[]> nexts = findNextMoves(map, n, new int[] {i, j});
            		for (int[] next : nexts) {
            			temp[i][j] += 0.125 * prob[next[0]][next[1]];
            		}
            	}
            }
        	prob = temp;
        	k--;
        }
        List<int[]> nexts = findNextMoves(map, n, new int[] {row, column});
        double result = 0;
		for (int[] next : nexts) {
			result += 0.125 * prob[next[0]][next[1]];
		}
        return result;
    }
	
	private boolean isValidPosition(int N, int[] cur){
	    return cur[0] > - 1 && cur[0] < N && cur[1] > -1 && cur[1] < N;
	}
	
	private List<int[]> findNextMoves(Map<Integer, List<int[]>> map, int N, 
			int[] cur) {
		int key = cur[0] * N + cur[1];
	    if(map.get(key) != null) return map.get(key);
	    List<int[]> list = new ArrayList<>();
	    int[] next;
	    if(isValidPosition(N, (next = new int[] {cur[0] + 2, cur[1] + 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 2, cur[1] - 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 2, cur[1] + 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 2, cur[1] - 1}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 1, cur[1] + 2}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] + 1, cur[1] - 2}))) 
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 1, cur[1] + 2})))
	    	list.add(next);
	    if(isValidPosition(N, (next = new int[] {cur[0] - 1, cur[1] - 2})))
	    	list.add(next);
	    map.put(key, list);
	    return list;
  }
}
