package com.prep2020.easy;

public class Problem836 {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return areIntervalsIntersected(new int[] {rec1[0], rec1[2]}, new int[] {rec2[0], rec2[2]})
        		&& areIntervalsIntersected(new int[] {rec1[1], rec1[3]}, new int[] {rec2[1], rec2[3]});
    }
	
	private boolean areIntervalsIntersected(int[] intv1, int[] intv2) {
		
		if (intv2[0] >= intv1[1] || intv1[0] >= intv2[1] || intv1[0] == intv1[1] 
				|| intv2[0] == intv2[1]) return false;
		return true;
	}
}
