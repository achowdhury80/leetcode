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
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    Set<String> set = new HashSet<>();
	    for (int[] p : points) {
	    	min = Math.min(min, p[0]);
	    	max = Math.max(max, p[0]);
	    	set.add(p[0] + ":" + p[1]);
	    }
	    int sum = max + min;
	    for(int[] p : points) {
	    	if (!set.contains( (sum - p[0])+ ":" + p[1])) return false;
	    }
	    
	    return true;
    }
}
