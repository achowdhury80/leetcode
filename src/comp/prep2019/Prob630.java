package comp.prep2019;

import java.util.*;

public class Prob630 {
	public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (x, y) -> (x[1] - y[1]));
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        int time = 0;
        for (int[] c : courses) {
        	if (c[0] + time <= c[1]) {
        		q.offer(c[0]);
        		time += c[0];
        	} else if (!q.isEmpty() && q.peek() > c[0]) {
        		time += c[0] - q.poll();
        		q.offer(c[0]);
        	}
        }
        return q.size();
    }
}
