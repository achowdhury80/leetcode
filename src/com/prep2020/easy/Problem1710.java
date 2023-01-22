package com.prep2020.easy;
import java.util.*;
public class Problem1710 {
	/**
	 * O(nlogN)
	 * @param boxTypes
	 * @param truckSize
	 * @return
	 */
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int result = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
        	if (boxTypes[i][0] <= truckSize) {
        		result += boxTypes[i][0] * boxTypes[i][1];
        		truckSize -= boxTypes[i][0];
        	} else {
        		result += truckSize * boxTypes[i][1];
        		truckSize = 0;
        	}
        }
        return result;
    }
}
