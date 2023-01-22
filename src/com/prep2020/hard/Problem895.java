package com.prep2020.hard;
import java.util.*;
public class Problem895 {
	/**
	 * O(1) time and O(N) space
	 */
	private int maxFreq;
	private Map<Integer, Integer> freqMap;
	private Map<Integer, Deque<Integer>> freqGroupMap;
	public Problem895() {
		freqMap = new HashMap<>();
		freqGroupMap = new HashMap<>();
    }
    /**
     * we are maintaining a map of all frequencies
     * lets say this item are added, 1, 2, 2, 3, 4, 4, 3
     * freqGroupMap snaps after each push
     * 1 - [1]
     * 1 - [2, 1]
     * 1 - [2, 1] 2 - [2]
     * 1 - [3, 2, 1] 2 - [2]
     * 1 - [4, 3, 2, 1] 2 - [2]
     * 1 - [4, 3, 2, 1] 2 - [4, 2]
     * 1 - [4, 3, 2, 1] 2 - [3, 4, 2]
     * @param val
     */
    public void push(int val) {
    	int freq = freqMap.getOrDefault(val, 0) + 1;
    	freqMap.put(val, freq);
    	maxFreq = Math.max(maxFreq, freq);
    	freqGroupMap.computeIfAbsent(freq, z -> new ArrayDeque<>()).push(val);
    }
    
    public int pop() {
        int result = freqGroupMap.get(maxFreq).pop();
        freqMap.put(result, freqMap.get(result) - 1);
        if (freqGroupMap.get(maxFreq).size() == 0) maxFreq--;
        return result;
    }
}
