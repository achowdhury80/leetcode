package com.prep2020.medium;
import java.util.*;
public class Problem464 {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) 
        	return false;
        return helper(maxChoosableInteger, 0, 0, desiredTotal, new HashMap<>());
    }
	
	private boolean helper(int maxChoosableInteger, int chosenSoFar, int sum,
			int desiredTotal, Map<Integer, Boolean> cache) {
		if (cache.containsKey(chosenSoFar)) return cache.get(chosenSoFar);
		for (int i = 1; i <= maxChoosableInteger; i++) {
			if ((chosenSoFar & (1 << i)) != 0) continue;
			if (sum + i >= desiredTotal) {
				cache.put(chosenSoFar, true);
				return true;
			}
			if (!helper(maxChoosableInteger, chosenSoFar ^ (1 << i), sum + i, 
					desiredTotal, cache)) {
				cache.put(chosenSoFar, true);
				return true;
			}
		}
		cache.put(chosenSoFar, false);
		return false;
	}
}
