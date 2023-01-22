package com.prep2020.medium;
import java.util.*;
public class Problem539 {
	/**
	 * O(NLogN)
	 * @param timePoints
	 * @return
	 */
	public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (x, y) -> compare(x, y));
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
        	int[] arr1 = findHrMin(timePoints.get(i - 1)), 
        			arr2 = findHrMin(timePoints.get(i));
        	int diff = arr2[0] * 60 + arr2[1] - arr1[0] * 60 - arr1[1];
        	result = Math.min(result, diff);
        }
        int[] arr1 = findHrMin(timePoints.get(0)), 
    			arr2 = findHrMin(timePoints.get(timePoints.size() - 1));
        int diff = arr1[0] * 60 + arr1[1] - arr2[0] * 60 - arr2[1] + 1440;
    	result = Math.min(result, diff);
    	return result;
    }
	 
	private int compare(String time1, String time2) {
		int[] arr1 = findHrMin(time1), arr2 = findHrMin(time2);
		return arr1[0] == arr2[0] ? (arr1[1] - arr2[1]) : (arr1[0] - arr2[0]); 
	}
	
	private int[] findHrMin(String time) {
		String[] arr = time.split(":");
		return new int[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
	}
}
