package comp.prep2019.less1000;

import java.util.PriorityQueue;
import java.util.Queue;

public class Prob414 {
	public int thirdMax(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>((x, y) -> (0l + x - y) <= 0 ? -1 : 1);
        
        for (int a : nums) {
        	if (q.contains(a)) continue;
        	if (q.size() > 2 && q.peek() < a) {
        		q.poll();
        		q.offer(a);
        	} else if (q.size() < 3) q.offer(a);
        }
        if (q.size() == 3) return q.poll();
        while(q.size() > 1) q.poll();
        return q.poll();
    }
}
