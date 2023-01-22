package com.prep2020.medium;
import java.util.*;
public class Problem1642 {
	/**
	 * O(nlogN)
	 * @param heights
	 * @param bricks
	 * @param ladders
	 * @return
	 */
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int result = 0;
        List<Integer> lifts = new ArrayList<>();
        int brickSum = 0;
        for (int i = 1; i < heights.length; i++) {
        	if (heights[i] <= heights[i - 1]) {
        		result = i;
        		continue;
        	}
        	int lift = heights[i] - heights[i - 1];
        	int idx = Collections.binarySearch(lifts, lift);
        	if (idx < 0) idx = -(idx + 1);
        	lifts.add(idx, lift);
        	if (lifts.size() <= ladders) {
        		result = i;
        		continue;
        	}
        	int lastBrickIndex = lifts.size() - ladders - 1;
        	int toAdd = idx <= lastBrickIndex ? lift : lifts.get(lastBrickIndex);
        	if (brickSum + toAdd > bricks) break;
        	result = i;
        	brickSum += toAdd;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1642 problem = new Problem1642();
		//System.out.println(problem.furthestBuilding(new int[] {4,2,7,6,9,14,12}, 5, 1));
		System.out.println(problem.furthestBuilding(new int[] {3, 19}, 87, 1));
	}
}
