package comp.prep2019;

import java.util.Arrays;

public class Prob252 {
	public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[1] == y[1]) ? x[0] - y[0] : x[1] - y[1]);
        for (int i = 0; i < intervals.length - 1; i++) {
        	if(intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
