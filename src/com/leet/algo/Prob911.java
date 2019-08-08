package com.leet.algo;
import java.util.*;
public class Prob911 {
	private Map<Integer, Integer> voteCount;
	private TreeMap<Integer, Integer> winnerMap;
	public Prob911(int[] persons, int[] times) {
		voteCount = new HashMap<>();
		winnerMap = new TreeMap<>();
		int[] max = new int[] {persons[0], 1};
		winnerMap.put(times[0], persons[0]);
		voteCount.put(persons[0], 1);
		for (int i = 1; i < times.length; i++) {
			voteCount.put(persons[i], voteCount.getOrDefault(persons[i], 0) + 1);
			int curCount = voteCount.get(persons[i]);
			if (curCount >= max[1]) {
				winnerMap.put(times[i], persons[i]);
				max[0] = persons[i];
				max[1] = curCount;
			} 
		}
    }
    
    public int q(int t) {
        return winnerMap.floorEntry(t).getValue();
    }
}
