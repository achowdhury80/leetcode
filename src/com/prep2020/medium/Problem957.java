package com.prep2020.medium;
import java.util.*;
public class Problem957 {
	public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Integer> nextMap = new HashMap<>();
        Map<Integer, Integer> dayMap = new HashMap<>();
        int cur = encodeState(cells);
        dayMap.put(cur, 0);
        for (int i = 1; i <= n; i++) {
        	int nextState = findNextState(cur, nextMap);
        	if (dayMap.containsKey(nextState)) {
        		int dis = i - dayMap.get(nextState);
        		int remainingDays = n - i;
        		int forward = (remainingDays / dis) * dis;
        		i += forward;
        	}
        	cur = nextState;
        	dayMap.put(cur, i);
        }
        return decodeState(cur);
    }
	
	private int findNextState(int cur, Map<Integer, Integer> nextMap) {
		if (nextMap.containsKey(cur)) return nextMap.get(cur);
		int[] old = decodeState(cur);
		int[] newCells = findNext(old);
		int newState = encodeState(newCells);
		nextMap.put(cur, newState);
		return newState;
	}
	
	private int[] findNext(int[] cur) {
		int[] next = new int[8];
		for (int i = 1; i < 7; i++) {
			if (cur[i - 1] == cur[i + 1]) next[i] = 1;
		}
		return next;
	}
	
	private int encodeState(int[] cells) {
		int cur = 0;
        for (int i = 0; i < cells.length; i++) {
        	cur |= (cells[i] << (7 - i));
        }
        return cur;
	}
	
	private int[] decodeState(int state) {
		int[] cells = new int[8];
        for (int i = 7; i > -1; i--) {
        	cells[8 - i - 1] = (state >> i) & 1;  
        }
        return cells;
	}
	
	public static void main(String[] args) {
		Problem957 problem = new Problem957();
		System.out.println(problem.prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0},
				1000000000));
	}
}
