package comp.prep2019;

import java.util.*;

public class Prob253 {
	public int minMeetingRooms1(int[][] intervals) {
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
	
	public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return 0;
        Queue<int[]> q= new PriorityQueue<>((x, y) -> (x[0] == y[0] 
        		? (y[1] - x[1]) : (x[0] - y[0])));
        for (int[] intv : intervals) {
        	q.offer(new int[] {intv[0], 0});
        	q.offer(new int[] {intv[1], 1});
        }
        int result = 0, count = 0;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (cur[1] == 0) count++;
        	else count--;
        	result = Math.max(result, count);
        }
        return result;
    }
}
