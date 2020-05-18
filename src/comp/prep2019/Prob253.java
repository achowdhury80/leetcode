package comp.prep2019;

import java.util.*;

public class Prob253 {
	public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return 0;
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        Queue<Integer> q= new PriorityQueue<>();
        int result = 1;
        for (int i = 0; i < intervals.length; i++) {
        	while(!q.isEmpty() && q.peek() <= intervals[i][0]) q.poll();
        	q.offer(intervals[i][1]);
        	result = Math.max(result, q.size());
        }
        return result;
    }
}
