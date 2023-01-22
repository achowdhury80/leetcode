package com.prep2020.medium;

import java.util.*;

public class Problem1993 {
	private int[] parent;
	Map<Integer, Integer> lockMap;
	Map<Integer, Set<Integer>> children;
	public Problem1993(int[] parent) {
        this.parent = parent;
        this.lockMap = new HashMap<>();
        children = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
        	Set<Integer> set = children.getOrDefault(parent[i], new HashSet<>());
        	set.add(i);
        	children.put(parent[i], set);
        }
    }
    
    public boolean lock(int num, int user) {
        if (lockMap.containsKey(num)) return false;
        lockMap.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if (lockMap.getOrDefault(num, -1) == user) {
        	lockMap.remove(num);
        	return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        
        int cur = num;
        while(cur != -1) {
        	if (lockMap.containsKey(cur)) return false;
        	cur = parent[cur];
        }
        
        if (!isDescendantLocked(num)) return false;
        unlockdescendant(num);
        lockMap.put(num, user);
        return true;
    }

	private void unlockdescendant(int num) {
		if (lockMap.containsKey(num)) lockMap.remove(num);
		Set<Integer> set = children.get(num);
		if (set == null) return;
		for (int child : set) unlockdescendant(child);
	}

	private boolean isDescendantLocked(int num) {
		Set<Integer> set = children.get(num);
		if (set == null) return false;
		for (int child : set) {
			if (lockMap.containsKey(child)) return true;
			if (isDescendantLocked(child)) return true;
		}
		return false;
	}
}
