package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob435 {
	
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int result = 0;
        int cur = 0;
        for (int i = 1; i < intervals.length; i++) {
        	if(intervals[i][0] >= intervals[cur][1]) {
        		cur = i;
        		continue;
        	} 
        	if (intervals[i][1] < intervals[cur][1]) cur = i;
        	result++;
        }
        return result;
    }
	
	public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        int result = 0;
        int cur = 0;
        for (int i = 1; i < intervals.length; i++) {
        	if(intervals[i][0] >= intervals[cur][1]) {
        		cur = i;
        		continue;
        	}
        	if (intervals[i][1] == intervals[cur][1]) {
        		result++;
        		cur = i;
        	} else {
        		result++;
        	}
        }
        return result;
    }
}
