package com.prep2020.hard;
import java.util.*;
public class Problem732 {
	private TreeMap<Integer, Integer> delta;
	public Problem732() {
        delta = new TreeMap<>();
    }
    
	/**
	 * O(N) time and space
	 * @param start
	 * @param end
	 * @return
	 */
    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);
        int result = 0, active = 0;
        for (int val : delta.values()) {
        	active += val;
        	result = Math.max(result, active);
        }
        return result;
    }
}
