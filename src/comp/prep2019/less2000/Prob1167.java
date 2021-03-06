package comp.prep2019.less2000;

import java.util.*;

public class Prob1167 {
	/**
	 * O(NlogN)
	 * @param sticks
	 * @return
	 */
	public int connectSticks(int[] sticks) {
        Queue<Integer> q = new PriorityQueue<>();
        int result = 0;
        for (int stick : sticks) q.offer(stick);
        while(q.size() > 1) {
        	int sum = q.poll() + q.poll();
        	result += sum;
        	q.offer(sum);
        }
        return result;
    }
}
