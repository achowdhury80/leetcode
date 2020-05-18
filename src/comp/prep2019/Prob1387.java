package comp.prep2019;
import java.util.*;
public class Prob1387 {
	public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 0);
        Queue<int[]> q = new PriorityQueue<>(
        		(x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        for (int i = lo; i <= hi; i++) q.offer(new int[] {i, findPower(i, cache)});
        for (int i = 0; i < k - 1; i++) q.poll();
        return q.peek()[0];
    }
	
	private int findPower(int x, Map<Integer, Integer> cache) {
		if (!cache.containsKey(x)) {
			int y = x;
			if (y % 2 == 0) y >>= 1;
			else y = y * 3 + 1;
			cache.put(x, 1 + findPower(y, cache));
		}
		return cache.get(x);
	}
	
	public static void main(String[] args) {
		Prob1387 prob = new Prob1387();
		System.out.println(prob.getKth(12, 15, 2));
	}
}
