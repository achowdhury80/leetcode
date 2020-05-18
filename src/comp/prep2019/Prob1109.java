package comp.prep2019;

public class Prob1109 {
	public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
        	result[booking[0] - 1] += booking[2];
        	if (booking[1] != n) {
        		result[booking[1]] -= booking[2];
        	}
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
        	cur += result[i];
        	result[i] = cur;
        }
        return result;
    }
}
