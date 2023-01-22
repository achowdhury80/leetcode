package com.prep2020.medium;
import java.util.*;
public class Problem756 {
	public boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String, Set<String>> nextsCache = new HashMap<>();
		for (String allow : allowed) {
			String curState = allow.substring(0, 2);
			Set<String> nextStates = nextsCache.getOrDefault(curState, new HashSet<>());
			nextStates.add("" + allow.charAt(2));
			nextsCache.put(curState, nextStates);
		}
        return helper(bottom, nextsCache, new HashSet<>());
    }
	
	private boolean helper(String bottom, Map<String, Set<String>> nextsCache, Set<String> notPossible) {
		if (bottom.length() == 1) return true;
		if (notPossible.contains(bottom)) return false;
		Set<String> nextStates = findNextStates(bottom, nextsCache);
		if (nextStates != null && nextStates.size() > 0) {
			for (String nextState : nextStates) {
				if (helper(nextState, nextsCache, notPossible)) return true;
			}
		}
		notPossible.add(bottom);
		return false;
	}

	private Set<String> findNextStates(String bottom, Map<String, Set<String>> nextsCache) {
		if (nextsCache.containsKey(bottom)) return nextsCache.get(bottom);
		if (bottom.length() == 2) {
			nextsCache.put(bottom, null);
			return null;
		}
		Set<String> result = new HashSet<>();
		
		if (!nextsCache.containsKey(bottom.substring(0, 2))) {
			nextsCache.put(bottom, null);
			return null;
		}
		Set<String> nexts = nextsCache.get(bottom.substring(0, 2));
		Set<String> remainingNexts = findNextStates(bottom.substring(1), nextsCache);
		if (nexts == null || nexts.size() == 0 || remainingNexts == null || remainingNexts.size() == 0) {
			nextsCache.put(bottom, null);
			return null;
		}
		for (String next : nexts) {
			for (String remainingNext : remainingNexts) {
				result.add(next + remainingNext);
			}
		}
		nextsCache.put(bottom, result);
		return nextsCache.get(bottom);
	}
}
