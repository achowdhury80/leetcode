package comp.prep2019;

public class Prob1344 {
	/**
	 * O(1)
	 * consider rotation from 12 o'clock
	 * @param hour
	 * @param minutes
	 * @return
	 */
	public double angleClock(int hour, int minutes) {
		// 1 min = 6 degree
        double minutesRotation = minutes * 6;
        double hourRotation = 0;
        if (hour < 12) hourRotation = hour * 30;
        if (minutes > 0) hourRotation += 0.5 * minutes;
        double angle = Math.abs(hourRotation - minutesRotation);
        if (angle > 180) return 360 - angle;
        return angle;
    }
}
