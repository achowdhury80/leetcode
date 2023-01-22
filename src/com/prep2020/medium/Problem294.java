package com.prep2020.medium;
import java.util.*;
public class Problem294 {
	/**
	 * O(2^n)
	 * @param currentState
	 * @return
	 */
	public boolean canWin(String currentState) {
        return helper(currentState, new HashMap<>());
    }
	
	private boolean helper(String currentState, Map<String, Boolean> cache) {
		if (cache.containsKey(currentState)) return cache.get(currentState);
		List<String> nextStates = findNextStates(currentState); 
		for (String next : nextStates) {
			boolean canWin = helper(next, cache);
			if (!canWin) {
				cache.put(currentState, true);
				return true;
			}
		}
		cache.put(currentState, false);
		return false;
	}
	
	private List<String> findNextStates(String currentState) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < currentState.length() - 1; i++) {
			if ("++".equals(currentState.substring(i, i + 2)))
				result.add(currentState.substring(0, i) + "--" 
						+ currentState.substring(i + 2));
		}
		return result;
	}
}
 