package comp.prep2019.less1000;
import java.util.*;
public class Prob514 {
	public int findRotateSteps(String ring, String key) {
        return helper(ring, key, 0, new HashMap<>());
    }
	
	private int helper(String ring, String key, int start, Map<String, Integer> cache) {
		if (start == key.length()) return 0;
		String cacheKey = ring + "#" + start;
		if (!cache.containsKey(cacheKey)) {
			int result = 0;
			char c = key.charAt(start);
			if (ring.charAt(0) == c) {
				result++;
				cache.put(cacheKey, result + helper(ring, key, start + 1, cache));
			} else {
				int fromIndex = 0, idx = -1;
				result = Integer.MAX_VALUE;
				while((idx = ring.indexOf(c, fromIndex)) > -1) {
					int numberOfMoveWithDirection = findNumberOfMoveWithDirection(ring, idx);
					int steps = Math.abs(numberOfMoveWithDirection) + 1;
					String newRing = rotate(ring, numberOfMoveWithDirection);
					result = Math.min(result, steps + helper(newRing, key, start + 1, cache));
					fromIndex = idx + 1;
					if (fromIndex == ring.length()) break;
				}
				cache.put(cacheKey, result);
			}
		}
		return cache.get(cacheKey);
	}
	
	
	// + for anticlockwise, and - for clockwise
	private int findNumberOfMoveWithDirection(String ring, int idx) {
		int clockwiseStep = ring.length() - idx;
		if (idx < clockwiseStep) return idx;
		return -clockwiseStep; 
	}
	
	private String rotate(String ring, int stepWithDirection) {
		if (stepWithDirection < 0) stepWithDirection = ring.length() + stepWithDirection;
		return ring.substring(stepWithDirection) + ring.substring(0, stepWithDirection);
	} 
	
	public static void main(String[] args) {
		Prob514 prob = new Prob514();
		System.out.println(prob.findRotateSteps("godding", "gd"));
	}
	
	
}
