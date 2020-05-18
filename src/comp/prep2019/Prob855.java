package comp.prep2019;
import java.util.*;

public class Prob855 {
	private int N;
	private PriorityQueue<Interval> pq;
	public Prob855(int N) {
        this.N= N;
        pq = new PriorityQueue<>((a, b) -> a.dist != b.dist ? b.dist - a.dist : a.x - b.x);
        pq.offer(new Interval(-1, N));
    }
    
    public int seat() {
        Interval interval = pq.poll();
        int seat = -1;
        if (interval.x == -1) seat = 0;
        else if (interval.y == N) seat = N - 1;
        else seat = (interval.x + interval.y) / 2;
        pq.offer(new Interval(interval.x, seat));
        pq.offer(new Interval(seat, interval.y));
        return seat;
    }
    
    public void leave(int p) {
        List<Interval> list = new ArrayList<>(pq);
        Interval head = null, tail = null;
        for (Interval interval : list) {
        	if (interval.x == p) tail = interval;
        	if (interval.y == p) head = interval;
        	if (head != null && tail != null) break;
        }
        Interval newInterval = new Interval(head.x, tail.y);
        pq.remove(head);
        pq.remove(tail);
        pq.offer(newInterval);
    }
    class Interval {
    	int x, y, dist;
    	public Interval(int x, int y) {
    		this.x = x;
    		this.y = y;
    		if(x == -1) {
    			this.dist = y;
    		} else if (y == N) {
    			this.dist = N - x - 1;
    		} else this.dist = (y - x) / 2;
    	}
    }
}
