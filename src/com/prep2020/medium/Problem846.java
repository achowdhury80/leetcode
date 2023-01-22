package com.prep2020.medium;
import java.util.*;
public class Problem846 {
	/**
	 *  O(NlogN)
	 * @param hand
	 * @param groupSize
	 * @return
	 */
	public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length, min = Integer.MAX_VALUE;
        if (n % groupSize != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int h : hand) {
        	min = Math.min(min, h);
        	treeMap.put(h, treeMap.getOrDefault(h, 0) + 1);
        }
        
        while(!treeMap.isEmpty()) {
        	int cur = treeMap.ceilingKey(min);
        	min = cur;
        	treeMap.put(cur, treeMap.get(cur) - 1);
        	if (treeMap.get(cur) == 0) treeMap.remove(cur);
        	for (int i = 1; i < groupSize; i++) {
        		cur++;
        		if (treeMap.containsKey(cur)) {
        			treeMap.put(cur, treeMap.get(cur) - 1);
        			if (treeMap.get(cur) == 0) treeMap.remove(cur);
        		} else return false;
        	}
        }
        
        return true;
        
    }
	
	public static void main(String[] args) {
		Problem846 problem = new Problem846();
		System.out.println(problem.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
	}
}
