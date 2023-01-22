package com.prep2020.medium;
import java.util.*;
public class Problem1583 {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		Map<Integer, Integer> pairMap = new HashMap<>();
		for (int[] pair : pairs) {
			pairMap.put(pair[0], pair[1]);
			pairMap.put(pair[1], pair[0]);
		}
		Map<Integer, Boolean> isHappy = new HashMap<>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (!checkHappy(isHappy, pairMap, i, preferences)) result++;
		}
        return result;
    }
	
	private boolean checkHappy(Map<Integer, Boolean> isHappy, 
			Map<Integer, Integer> pairMap, int x, int[][] preferences) {
		if (isHappy.containsKey(x)) return isHappy.get(x);
		int partner = pairMap.get(x);
		for (int pref : preferences[x]) {
			if (pref == partner) {
				isHappy.put(x, true);
				return true;
			}
			if (isUnHappy(isHappy, pairMap, pref, x, preferences)) {
				isHappy.put(x, false);
				return false;
			}
		}
		return true;
	}

	private boolean isUnHappy(Map<Integer, Boolean> isHappy, 
			Map<Integer, Integer> pairMap, int u, int x, int[][] preferences) {
		int partner = pairMap.get(u);
		for (int pref : preferences[u]) {
			if (pref == partner) return false;
			if (pref == x) {
				isHappy.put(u, false);
				return true;
			}
		}
		return false;
	}
}
