package comp.prep2019;
import java.util.*;
public class Prob1046 {
	public int lastStoneWeight(int[] stones) {
		if (stones.length == 1) return stones[0];
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        for (int w : stones) q.offer(w);
        while(q.size() > 1) {
        	int s1 = q.poll(), s2 = q.poll();
        	if (s1 != s2) {
        		q.offer(Math.abs(s1 - s2));
        	}
        }
        return q.size() == 0 ? 0 : q.poll();
    }
}
