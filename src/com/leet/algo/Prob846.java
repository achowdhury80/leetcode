package com.leet.algo;
import java.util.*;

public class Prob846 {
	public boolean isNStraightHand(int[] hand, int W) {
		if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i : hand) {
        	treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
        }
        while(!treeMap.isEmpty()) {
        	int first = treeMap.firstKey();
        	decrementOrRemove(treeMap, first);
        	for (int i = 1; i < W; i++) {
        		if (!treeMap.containsKey(first + i)) return false;
        		decrementOrRemove(treeMap, first + i);
        	}
        	
        }
        return true;
    }
	
	private void decrementOrRemove(TreeMap<Integer, Integer> treeMap, int key) {
		if (treeMap.get(key) == 1) treeMap.remove(key);
		else treeMap.put(key, treeMap.get(key) - 1);
	}
}
