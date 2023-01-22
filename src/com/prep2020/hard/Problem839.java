package com.prep2020.hard;

public class Problem839 {
	public int numSimilarGroups(String[] strs) {
		int n = strs.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		if (isSimilar(strs[i], strs[j])) {
        			int p1 = findParent(i, parent), p2 = findParent(j, parent);
        			if (p1 != p2) {
        				parent[Math.max(p1, p2)] = Math.min(p1, p2);
        			}
        		}
        	}
        }
        int result = 0;
        for (int i = 0; i < n; i++) if (parent[i] == i) result++;
        return result;
    }
	
	private int findParent(int i, int[] parent) {
		while(i != parent[i]) i = parent[i];
		return i;
	}

	private boolean isSimilar(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
				if (diff > 2) return false;
			}
		}
		return true;
	}
}
