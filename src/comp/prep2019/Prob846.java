package comp.prep2019;
import java.util.*;
public class Prob846 {
	public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>();
        for (int h : hand) {
        	map.put(h, map.getOrDefault(h, 0) + 1);
        	q.offer(h);
        }
        while(!q.isEmpty()) {
        	int h = q.poll();
        	if (map.get(h) == 0) continue;
        	map.put(h, map.get(h) - 1);
        	for (int i = 1; i < W; i++) {
        		int count = map.getOrDefault(h + i, 0);
        		if (count == 0) return false;
        		map.put(h + i, count - 1);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob846 prob = new Prob846();
		System.out.println(prob.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
	}
}
