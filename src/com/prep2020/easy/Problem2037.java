package com.prep2020.easy;

import java.util.Arrays;

public class Problem2037 {
	/**
	 * O(NLogN)
	 * @param seats
	 * @param students
	 * @return
	 */
	public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) 
        	result += Math.abs(seats[i] - students[i]);
        return result;
    }
}
