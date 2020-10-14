package comp.prep2019.less2000;

import java.util.*;

public class Prob1353 {
	public int maxEvents(int[][] events) {
		// returns the earlier one. if multiple have same start day, then return with
		// earliest end day
		Queue<int[]> q = new PriorityQueue<>(
				(x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
		// day number blocked so far
        int soFar = 0;
        int result = 0;
        for (int[] event : events) q.offer(event);
        while(!q.isEmpty()) {
        	int[] e = q.poll();
        	// if event end date less than equal to last blocked date
        	if (e[1] <= soFar) continue;
        	// now we need to make some adjustment
        	// we need to update all events for which start date is less than or 
        	// equal to soFar. those start days need to be changes to soFar + 1.
        	// if an event found which start day greater than soFar, update soFar
        	// to that event start day. update result
        	if(e[0] <= soFar) {
        		e[0] = soFar + 1;
        		q.offer(e);
        	} else {
        		result++;
        		soFar = e[0];
        	}
        }
        return result;
    }
}
