package com.prep2020.medium;

public class Problem1344 {
	/**
	 * O(1)
	 * @param hour
	 * @param minutes
	 * @return
	 */
	public double angleClock(int hour, int minutes) {
        double minAngle = 6 * minutes;
        double minutesMove = 0.5 * minutes;
        double hourAngle = 30 * hour + minutesMove;
        double diff = Math.abs(minAngle - hourAngle);
        return Math.min(diff, 360 - diff);
    }
}
