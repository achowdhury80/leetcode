package comp.prep2019;

import java.util.HashSet;
import java.util.Set;

public class Prob356 {
	/**
	 * the question is little ambiguous
	 * we need to find a line between max and min x-coOrdinate which is parallel to Y and all the points 
	 * needs to have a mirror reflection point 
	 * @param points
	 * @return
	 */
	public boolean isReflected(int[][] points) {
		if (points.length < 2) return true;
		int minX = Integer.MAX_VALUE, maxX= Integer.MIN_VALUE;
		Set<String> set = new HashSet<>();
		for (int[] p : points) {
			minX = Math.min(minX, p[0]);
			maxX = Math.max(maxX, p[0]);
			set.add(p[0] + ":" + p[1]);
		}
		int mirrorX = minX + maxX;
		for (int[] p : points) {
			if (!set.contains((mirrorX - p[0]) + ":" + p[1])) return false;
		}
		return true;
    }
}
