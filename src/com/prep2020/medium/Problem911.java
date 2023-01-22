package com.prep2020.medium;
import java.util.*;
public class Problem911 {
	private TreeMap<Integer, Integer> treeMap;
	
	public Problem911(int[] persons, int[] times) {
		int winner = -1, votes = 0;
		Map<Integer, Integer> counts = new HashMap<>();
        treeMap = new TreeMap<>();
        for (int i = 0; i < persons.length; i++) {
        	int count = counts.getOrDefault(persons[i], 0) + 1;
        	counts.put(persons[i], count);
        	if (count >= votes) {
        		votes = count;
        		if (winner != persons[i]) {
        			winner = persons[i];
        			treeMap.put(times[i], winner);
        		} 
        	}
        }
    }
    
    public int q(int t) {
        return treeMap.floorEntry(t).getValue();
    }
}
