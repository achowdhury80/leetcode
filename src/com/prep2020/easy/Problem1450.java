package com.prep2020.easy;

public class Problem1450 {
	/**
	 * O(N)
	 * @param startTime
	 * @param endTime
	 * @param queryTime
	 * @return
	 */
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
        	if (startTime[i] <= queryTime && queryTime <= endTime[i]) result++;
        }
        return result;
    }
}
